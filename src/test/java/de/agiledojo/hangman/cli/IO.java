package de.agiledojo.hangman.cli;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.fail;

public class IO {

    private boolean waitForOutput;
    private final ByteArrayOutputStream stdOut;


    public static IO create() {
        return new IO(initializeStdOut());
    }



    public static ByteArrayOutputStream initializeStdOut() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        return baos;
    }

    private IO(ByteArrayOutputStream stdOut) {
        this.stdOut =stdOut;
    }

    public void assertOutputToBe(String output) {
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


    public static void startApplicationWithArgument(String argument) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> Hangman.main(new String[]{argument}));
    }
}