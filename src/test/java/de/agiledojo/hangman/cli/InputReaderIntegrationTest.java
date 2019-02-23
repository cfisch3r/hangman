package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.test.MockStdIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InputReaderIntegrationTest {
    private MockStdIn stdIn;
    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        stdIn = MockStdIn.create();
        inputReader = new InputReader();
    }

    @Test
    void noLineWithoutInput() {
        Optional<String> line = inputReader.readNextInput();
        assertThat(line).isEmpty();
    }

    @Test
    void LineWithInput() {
        stdIn.enter("ö\n");
        Optional<String> line = inputReader.readNextInput();
        assertThat(line).hasValue("ö");
    }

    @Test
    void multiplesLines() {
        stdIn.enter("ö\na\n");
        inputReader.readNextInput();
        Optional<String> line = inputReader.readNextInput();
        assertThat(line).hasValue("a");
    }
}
