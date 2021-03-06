package de.agiledojo.hangman;

public interface Display {
    void show(String board);

    void showResult(long numberOfFailures);

    void showError(String reason);
}
