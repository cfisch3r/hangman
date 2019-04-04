package de.agiledojo.hangman;

public interface Display {
    void show(String board);

    void showResult(String message);

    void showFailures(long numberOfFailures);
}
