package de.agiledojo.hangman.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static de.agiledojo.hangman.cli.IO.initializeStdOut;
import static de.agiledojo.hangman.cli.IO.enter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class HangmanAcceptanceTest {

    private ByteArrayOutputStream stdOut;
    private ExecutorService executor;
    private boolean waitForOutput;

    @BeforeEach
    void setUp() {
        stdOut = initializeStdOut();
    }

    @Test
    void showsPlaceHoldersWhenWordDoesNotContainProvidedLetter() {
        enter("q");
        startApplicationWithArgument("Secret");
        assertOutputToBe("------\n");
    }

    @Test
    void showsMatchingLettersInBoard() {
        enter("s\ne");
        startApplicationWithArgument("Secret");
        assertOutputToBe("S-----\nSe--e-\n");
    }

    @Test
    void showsMessageWhenBoardIsComplete() {
        enter("t\nd\n");
        startApplicationWithArgument("TDD");
        assertOutputToBe("T--\nTDD\nYou won!\n");
    }

    private void assertOutputToBe(String output) {
        waitForOutput = true;
        Timer timer = new Timer("timeout");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                stopWaitingForOutput();
            }
        },100);
        boolean match = false;
        while(waitForOutput && !match) {
            match = stdOut.toString().equals(output);
        }
        if (!match)
            fail("Expected: " + output + "\nActual: " + stdOut);
    }

    private void stopWaitingForOutput() {
        waitForOutput = false;
    }


    private void startApplicationWithArgument(String argument) {
        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> Hangman.main(new String[]{argument}));
    }
}
