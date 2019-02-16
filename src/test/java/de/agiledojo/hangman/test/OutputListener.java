package de.agiledojo.hangman.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import static org.assertj.core.api.Assertions.fail;

public class OutputListener {

    private class TimeOutTimer {
        private boolean isRunning = true;

        private void start(int timeout) {
            Timer timer = new Timer("timeout");
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isRunning = false;
                }
            }, timeout);
        }

    }

    private final ByteArrayOutputStream stdOut;


    public static OutputListener create() {
        return new OutputListener(initializeStdOut());
    }



    private static ByteArrayOutputStream initializeStdOut() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        return baos;
    }

    private OutputListener(ByteArrayOutputStream stdOut) {
        this.stdOut =stdOut;
    }

    public void assertOutputToBe(String output) {
        if (!isMatch(output))
            fail("Expected: " + output + "\nActual: " + stdOut);
    }

    private boolean isMatch(String output) {
        TimeOutTimer timer = startTimeOut();
        boolean match = false;
        while(timer.isRunning && !match) {
            match = stdOut.toString().equals(output);
        }
        return match;
    }

    private TimeOutTimer startTimeOut() {
        TimeOutTimer timer = new TimeOutTimer();
        timer.start(100);
        return timer;
    }


}