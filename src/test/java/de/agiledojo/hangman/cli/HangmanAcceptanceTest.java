package de.agiledojo.hangman.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static de.agiledojo.hangman.cli.IO.initializeStdOut;
import static de.agiledojo.hangman.cli.IO.enter;
import static org.assertj.core.api.Assertions.assertThat;

class HangmanAcceptanceTest {

    private ByteArrayOutputStream stdOut;

    @BeforeEach
    void setUp() {
        stdOut = initializeStdOut();
    }

    @Test
    void showsPlaceHoldersWhenWordDoesNotContainProvidedLetter() {
        enter("q");
        runApplicationWithArgument("Secret");
        assertOutputToBe("------\n");
    }


    private void assertOutputToBe(String output) {
        assertThat(stdOut.toString()).isEqualTo(output);
    }


    private void runApplicationWithArgument(String argument) {
        Hangman.main(new String[]{argument});
    }
}
