package de.agiledojo.hangman.game;

import java.util.function.IntFunction;
import java.util.stream.Collectors;

class DefaultHangmanGame implements HangmanGame {
    private static final String PLACEHOLDER = "-";
    private final String word;
    private final Display display;
    private String guessedLetters;

    DefaultHangmanGame(String word, Display display) {
        this.word = word;
        this.display = display;
    }

    @Override
    public void guess(String letter) {
        guessedLetters += letter.toLowerCase();
        display.showBoard(createBoard());
    }

    private String createBoard() {
        return word.chars().mapToObj(ev()).collect(Collectors.joining());
    }

    private IntFunction<String> ev() {
        return character -> {
            String letter = String.valueOf((char) character);
            return guessedLetters.contains(letter.toLowerCase())? letter : PLACEHOLDER;
        };
    }
}
