package de.agiledojo.hangman.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationRunner {

    public static class ApplicationStatus {

        private boolean finished;

        private synchronized void setToFinished() {
            finished = true;
            this.notifyAll();
        }


        public void assertToBeFinishedWithin(int timeout) {
            TimeOutTimer timer = new TimeOutTimer();
            while (!finished) {
                if (!timer.isRunning)
                    fail("not finished");
                timer.waitFor(this,timeout);
            }
        }
    }

    public static ApplicationStatus startApplicationWithArgument(Consumer<String[]> main, String argument) {
        ApplicationStatus applicationStatus = new ApplicationStatus();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
           main.accept(new String[]{argument});
           applicationStatus.setToFinished();
        });
        return applicationStatus;
    }
}
