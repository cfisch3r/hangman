package de.agiledojo.hangman.game;

public interface HangmanGame {

    enum Result {
        INCOMPLETE, DONE
    }

    static HangmanGame create(String word, Display display) {
        return new DefaultHangmanGame(word,display);
    }

    Result guess(String letter);
}
