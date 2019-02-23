package de.agiledojo.hangman.test;

import de.agiledojo.hangman.cli.Hangman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationRunner {

    public static class ApplicationStatus {

        private boolean finished;

        private synchronized void setToFinished() {
            finished = true;
            this.notifyAll();
        }


        public void assertToBeEventuallyFinished(int timeout) {
            TimeOutTimer timer = new TimeOutTimer();
            while (!finished) {
                if (!timer.isRunning)
                    fail("not finished");
                timer.waitFor(this,timeout);
            }
        }
    }

    public static ApplicationStatus startApplicationWithArgument(String argument) {
        ApplicationStatus applicationStatus = new ApplicationStatus();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            Hangman.main(new String[]{argument});
            applicationStatus.setToFinished();
        });
        return applicationStatus;
    }
}
