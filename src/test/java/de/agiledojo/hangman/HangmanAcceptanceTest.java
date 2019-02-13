package de.agiledojo.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class HangmanAcceptanceTest {

    private ByteArrayOutputStream stdOut;

    @BeforeEach
    void setUp() {
        stdOut = initializeStdOut();
    }

    @Test
    void showsPlaceHoldersWhenWordDoesNotContainProvidedLetter() {
        sendToStdIn("q");
        runApplicationWithArgument("Secret");
        assertOutputToBe("------\n");
    }

    private ByteArrayOutputStream initializeStdOut() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        return baos;
    }

    private void sendToStdIn(String input) {

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void assertOutputToBe(String output) {
        assertThat(stdOut.toString()).isEqualTo(output);
    }


    private void runApplicationWithArgument(String argument) {
        Hangman.main(new String[]{argument});
    }
}
