package de.agiledojo.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HangmanGameSpec {

    @Mock
    private Display display;
    private DefaultHangmanGame game;

    @BeforeEach
    void setUp() {
        game = new DefaultHangmanGame("Secret",display);
    }

    @Test
    void showsPlaceHoldersInBoardWhenInputDoesNotMatch() {
        guess("ü");
        verify(display).show("------");
    }

    @Test
    void showsCharactersInBoardWhereInputMatch() {
        guess("e");
        verify(display).show("-e--e-");
    }

    @Test
    void ignoresCasesForInput() {
        guess("s");
        verify(display).show("S-----");
    }

    @Test
    void cumulatesSubsequentInputs() {
        guess("r");
        guess("t");
        InOrder inOrder = inOrder(display);
        inOrder.verify(display).show("---r--");
        inOrder.verify(display).show("---r-t");
    }

    @Test
    void showsSuccessWhenGameIsComplete() {
        guess("s");
        guess("e");
        guess("c");
        guess("r");
        guess("t");
        verify(display).showResult(anyLong());
    }

    @Test
    void isCompleteWhenAllCharactersAreFound() {
        guess("s");
        guess("e");
        guess("c");
        guess("r");
        guess("t");
        assertThat(game.isIncomplete()).isFalse();
    }

    @Test
    void showsFailuresWhenGameIsComplete() {
        guess("s");
        guess("e");
        guess("c");
        guess("r");
        guess("x");
        guess("q");
        guess("t");
        verify(display).showResult(2L);
    }

    @Test
    void showsErrorWhenInputIsNotASingleLetter() {
        guess("ab");
        verify(display).showError("Only single letters are allowed.");
    }

    @Test
    void showsErrorWhenInputIsEmpty() {
        guess("");
        verify(display).showError("You must enter a letter.");
    }

    @Test
    void ignoresInvalidInput() {
        guess("se");
        verify(display).show("------");
    }

    private void guess(String input) {
        game.guess(input);
    }
}
