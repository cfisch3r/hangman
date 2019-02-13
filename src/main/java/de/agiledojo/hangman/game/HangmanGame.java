package de.agiledojo.hangman.game;

public interface HangmanGame {

    static HangmanGame create(String word, Display display) {
        return new DefaultHangmanGame(word,display);
    }

    void guess(String letter);
}
