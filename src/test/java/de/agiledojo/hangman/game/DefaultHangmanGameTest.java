package de.agiledojo.hangman.game;

import de.agiledojo.hangman.game.HangmanGame.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static de.agiledojo.hangman.game.HangmanGame.Result.DONE;
import static de.agiledojo.hangman.game.HangmanGame.Result.INCOMPLETE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultHangmanGameTest {

    @Mock
    private Display display;

    private DefaultHangmanGame game;

    @BeforeEach
    void setUp() {
        game = new DefaultHangmanGame("Secret",display);
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
    void gameIsOverWhenAllLettersAreGuessed() {
        game.guess("s");
        game.guess("e");
        game.guess("c");
        game.guess("r");
        Result result = game.guess("t");
        assertThat(result).isEqualTo(DONE);
    }

    @Test
    void gameIsIncompleteWhenNotAllLettersAreFound() {
        Result result = game.guess("e");
        assertThat(result).isEqualTo(INCOMPLETE);
    }

}
