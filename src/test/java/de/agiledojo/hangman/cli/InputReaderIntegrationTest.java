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
    void readsNoLineWithoutInput() {
        Optional<String> line = inputReader.nextLine();
        assertThat(line).isEmpty();
    }

    @Test
    void readsLineFromInput() {
        stdIn.enter("ö\n");
        Optional<String> line = inputReader.nextLine();
        assertThat(line).hasValue("ö");
    }

    @Test
    void readsIncrementallyMultipleLines() {
        stdIn.enter("ö\na\n");
        inputReader.nextLine();
        Optional<String> line = inputReader.nextLine();
        assertThat(line).hasValue("a");
    }
}
