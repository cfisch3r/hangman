package de.agiledojo.hangman.game;

public interface HangmanGame {

    static HangmanGame create(String word, Display display, Context context) {
        return new DefaultHangmanGame(word,display,context);
    }

    void guess(String letter);
}
