package de.agiledojo.hangman;

import de.agiledojo.hangman.test.ApplicationRunner;
import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HangmanAcceptanceTest {

    private MockStdIn mockStdIn;
    private OutputListener outputListener;

    @BeforeEach
    void setUpTestFixture() {
        mockStdIn = MockStdIn.create();
        outputListener = OutputListener.create();
    }

    @Test
    void boardHasOnlyPlaceHolderWhenInputDoesNotMatch() {
        startApplication("Secret");
        enter("ö");
        assertOutputToBe("------\n");
    }

    private void assertOutputToBe(String output) {
        outputListener.assertOutputToBe(output);
    }

    private void enter(String line) {
        mockStdIn.enter(line);
    }

    private ApplicationRunner.ApplicationStatus startApplication(String secret) {
        return ApplicationRunner.startApplicationWithArgument(Hangman::main, secret);
    }
}
