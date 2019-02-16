package de.agiledojo.hangman.test;

import de.agiledojo.hangman.cli.Hangman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationRunner {

    public static void startApplicationWithArgument(String argument) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> Hangman.main(new String[]{argument}));
    }
}
