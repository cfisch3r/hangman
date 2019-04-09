package de.agiledojo.hangman;

import de.agiledojo.hangman.test.ApplicationRunner;
import de.agiledojo.hangman.test.ApplicationRunner.ApplicationStatus;
import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.*;

@DisplayName("Given a running Hangman Game")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HangmanE2ETest {

    private MockStdIn mockStdIn;
    private OutputListener outputListener;
    private ApplicationStatus applicationStatus;

    @BeforeEach
    void setUpTestFixture() {
        mockStdIn();
        mockStdOut();
        startApplicationWithArgument("Secret");
    }

    @Nested
    class When_entering_guesses {
        @BeforeEach
        void setUp() {
            enter("s");
            enter("x");
            enter("e");
        }

        @Test
        void then_the_Board_shows_the_current_status() {
            outputShouldContain("S-----\n");
            outputShouldContain("S-----\n");
            outputShouldContain("Se--e-\n");
        }
    }

    @Nested
    class When_finishing_the_Game {

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
        void then_a_success_message_is_shown() {
            outputShouldContain("You won!\n");
        }

        @Test
        void then_a_failure_statistic_is_shown() {
            outputShouldContain("1 Failure(s)\n");
        }

        @Test
        void then_application_exits() {
            applicationStatus.assertToBeFinishedWithin(100);
        }
    }


    private void outputShouldContain(String output) {
        outputListener.assertOutputToContain(output);
    }

    private void enter(String line) {
        mockStdIn.enter(line);
    }

    private void startApplicationWithArgument(String secret) {
        applicationStatus = ApplicationRunner.startApplicationWithArgument(Hangman::main, secret);
    }

    private void mockStdOut() {
        outputListener = OutputListener.create();
    }

    private void mockStdIn() {
        mockStdIn = MockStdIn.create();
    }
}
