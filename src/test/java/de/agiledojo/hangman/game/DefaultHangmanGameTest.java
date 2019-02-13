package de.agiledojo.hangman.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultHangmanGameTest {

    @Mock
    private Display display;

    @Test
    void showsPlaceHoldersWithoutMatchingLetter() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("a");
        verify(display).showBoard("------");
    }

    @Test
    void showsMatchingLetters() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("e");
        verify(display).showBoard("-e--e-");
    }

    @Test
    void matchingIsCaseInsensitive() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("s");
        verify(display).showBoard("S-----");
    }

    @Test
    void matchingIsCumulative() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("s");
        game.guess("e");
        verify(display).showBoard("Se--e-");
    }
}
