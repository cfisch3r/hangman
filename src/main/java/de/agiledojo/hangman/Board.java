package de.agiledojo.hangman;

import java.util.stream.Collectors;

public class Board {

    private static final String PLACEHOLDER_LETTER = "-";

    private String secret;
    private Display display;

    public Board(String secret, Display display) {
        this.secret = secret;
        this.display = display;
    }

    void show(String inputs) {
        display.show(boardView(inputs));
    }

    private String boardView(String inputs) {
        return secret.chars().mapToObj(character -> mapToBoardSymbol(character, inputs)).collect(Collectors.joining());
    }

    private String mapToBoardSymbol(int character, String inputs) {
        String letter = String.valueOf((char) character);
        return inputs.toLowerCase().contains(letter.toLowerCase())? letter : PLACEHOLDER_LETTER;
    }
}
