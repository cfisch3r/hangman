package de.agiledojo.hangman.test;

import de.agiledojo.hangman.cli.Hangman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ApplicationRunner {

    public static class ApplicationStatus {

        private Future<?> future;

        private ApplicationStatus(Future<?> future) {
            this.future = future;
        }

        public boolean isDone() {
            return future.isDone();
        }
    }

    public static ApplicationStatus startApplicationWithArgument(String argument) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            Hangman.main(new String[]{argument});
            return 0;
        });
        return new ApplicationStatus(future);
    }
}
