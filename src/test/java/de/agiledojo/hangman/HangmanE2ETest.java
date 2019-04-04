package de.agiledojo.hangman;

import de.agiledojo.hangman.test.ApplicationRunner;
import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Hangman Game should ...")
public class HangmanE2ETest {

    private MockStdIn mockStdIn;
    private OutputListener outputListener;

    @BeforeEach
    void setUpTestFixture() {
        mockStdIn();
        mockStdOut();
    }

    @Test
    @DisplayName("shows a board with placeholders, when input does not match.")
    void boardHasOnlyPlaceHolderWhenInputDoesNotMatch() {
        startApplicationWithArgument("Secret");
        enter("s");
        outputShouldContain("S-----\n");
        enter("e");
        outputShouldContain("Se--e-\n");
        enter("x");
        outputShouldContain("Se--e-\n");
        enter("c");
        outputShouldContain("Sec-e-\n");
        enter("r");
        outputShouldContain("Secre-\n");
        enter("t");
        outputShouldContain("Secret\n");
        outputShouldContain("You won!\n");
        outputShouldContain("1 Failure(s)\n");
    }

    private void outputShouldBe(String output) {
        outputListener.assertOutputToBe(output);
    }

    private void outputShouldContain(String output) {
        outputListener.assertOutputToContain(output);
    }

    private void enter(String line) {
        mockStdIn.enter(line);
    }

    private void startApplicationWithArgument(String secret) {
        ApplicationRunner.startApplicationWithArgument(Hangman::main, secret);
    }

    private void mockStdOut() {
        outputListener = OutputListener.create();
    }

    private void mockStdIn() {
        mockStdIn = MockStdIn.create();
    }
}
