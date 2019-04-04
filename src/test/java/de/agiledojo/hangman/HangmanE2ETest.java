package de.agiledojo.hangman;

import de.agiledojo.hangman.test.ApplicationRunner;
import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Given a running Hangman Game")
class HangmanE2ETest {

    private MockStdIn mockStdIn;
    private OutputListener outputListener;

    @BeforeEach
    void setUpTestFixture() {
        mockStdIn();
        mockStdOut();
        startApplicationWithArgument("Secret");
    }

    @Nested
    class WhenEnteringGuesses {
        @BeforeEach
        void setUp() {
            enter("s");
            enter("x");
            enter("e");
        }

        @Test
        void thenTheBoardShowsTheCurrentStatus() {
            outputShouldContain("S-----\n");
            outputShouldContain("S-----\n");
            outputShouldContain("Se--e-\n");
        }
    }

    @Nested
    class WhenPlayingtheCompleteGame {

        @BeforeEach
        void setUp() {
            enter("s");
            enter("e");
            enter("x");
            enter("c");
            enter("r");
            enter("t");
        }

        @Test
        void thenASuccessMessageIsShown() {
            outputShouldContain("You won!\n");
        }

        @Test
        void thenFailuresAreShown() {
            outputShouldContain("1 Failure(s)\n");
        }
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
