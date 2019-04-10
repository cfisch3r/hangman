package de.agiledojo.hangman;

public interface HangmanGame {
    void guess(String input);

    boolean isComplete();
}
