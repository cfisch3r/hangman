package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.HangmanGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static de.agiledojo.hangman.cli.IO.enter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InputReaderIntegrationTest {
    @Mock
    private HangmanGame hangmanGame;

    @Test
    void readsInputAsGuess() {
        enter("a\n");
        InputReader inputReader = new InputReader(hangmanGame);
        inputReader.readNextInput();
        verify(hangmanGame).guess("a");
    }

    @Test
    void returnsTrueWhenLineWasRead() {
        enter("a\n");
        InputReader inputReader = new InputReader(hangmanGame);
        boolean result = inputReader.readNextInput();
        assertThat(result).isTrue();
    }

    @Test
    void returnsFalseWhenLineWasRead() {
        enter("");
        InputReader inputReader = new InputReader(hangmanGame);
        boolean result = inputReader.readNextInput();
        assertThat(result).isFalse();
    }
}
