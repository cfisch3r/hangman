package de.agiledojo.hangman.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultHangmanGameTest {

    @Mock
    private Display display;

    @Mock
    private Context context;

    private DefaultHangmanGame game;

    @BeforeEach
    void setUp() {
        game = new DefaultHangmanGame("Secret",display,context);
    }

    @Test
    void showsPlaceHoldersWithoutMatchingLetter() {
        game.guess("a");
        verify(display).showBoard("------");
    }

    @Test
    void showsMatchingLetters() {
        game.guess("e");
        verify(display).showBoard("-e--e-");
    }

    @Test
    void matchingIsCaseInsensitive() {
        game.guess("s");
        verify(display).showBoard("S-----");
    }

    @Test
    void matchingIsCumulative() {
        game.guess("s");
        game.guess("e");
        verify(display).showBoard("Se--e-");
    }

    @Test
    void showsMessageWhenBoardIsComplete() {
        game.guess("s");
        game.guess("e");
        game.guess("c");
        game.guess("r");
        game.guess("t");
        verify(display).showMessage("You won!");
    }

    @Test
    void stopsContextWhenBoardIsComplete() {
        game.guess("s");
        game.guess("e");
        game.guess("c");
        game.guess("r");
        game.guess("t");
        verify(context).stop();
    }
}
