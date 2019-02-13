package de.agiledojo.hangman.game;

import java.util.stream.Collectors;

class DefaultHangmanGame implements HangmanGame {
    private static final String PLACEHOLDER = "-";
    private final String word;
    private final Display display;

    DefaultHangmanGame(String word, Display display) {
        this.word = word;
        this.display = display;
    }

    @Override
    public void guess(String letter) {
        display.showBoard(createBoard());
    }

    private String createBoard() {
        return word.chars().mapToObj(character -> PLACEHOLDER).collect(Collectors.joining());
    }
}
