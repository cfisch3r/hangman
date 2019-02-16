package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.HangmanGame;
import de.agiledojo.hangman.test.MockStdIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InputReaderIntegrationTest {
    @Mock
    private HangmanGame hangmanGame;
    private MockStdIn stdIn;
    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        stdIn = MockStdIn.create();
        inputReader = new InputReader(hangmanGame);
    }

    @Test
    void readsInputAsGuess() {
        stdIn.enter("ö");
        inputReader.readNextInput();
        verify(hangmanGame).guess("ö");
    }

    @Test
    void noGuessWithoutInput() {
        inputReader.readNextInput();
        verify(hangmanGame,never()).guess(any());
    }
}
