package de.agiledojo.hangman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HangmanGameSpec {

    @Mock
    private Display display;

    @Test
    void showsPlaceHoldersInBoardWhenInputDoesNotMatch() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("ü");
        verify(display).show("------");
    }

    @Test
    void showsCharactersInBoardWhereInputMatch() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("e");
        verify(display).show("-e--e-");
    }

    @Test
    void ignoresCasesForInput() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("s");
        verify(display).show("S-----");
    }
}
