package de.agiledojo.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultHangmanGame implements HangmanGame{
    private static final String PLACEHOLDER_LETTER = "-";
    private final String secret;
    private final Display display;
    private final List<String> inputs;

    public DefaultHangmanGame(String secret, Display display) {
        this.secret = secret;
        this.display = display;
        inputs = new ArrayList<>();
    }

    @Override
    public void guess(String input) {
        addInput(input);
        String board = createBoard();
        display.show(board);
        if (gameIsFinished(board)) {
            display.showResult("You won!");
            display.showFailures(failures());
        }
    }

    private boolean gameIsFinished(String board) {
        return !board.contains(PLACEHOLDER_LETTER);
    }

    private void addInput(String input) {
        inputs.add(input.toLowerCase());
    }

    private long failures() {
        return inputs.stream().filter(((i) -> !secret.toLowerCase().contains(i))).count();
    }

    private String createBoard() {
        return secret.chars().mapToObj(this::mapToBoardSymbol).collect(Collectors.joining());
    }

    private String mapToBoardSymbol(int character) {
        String letter = String.valueOf((char) character);
        return inputs.contains(letter.toLowerCase())? letter : PLACEHOLDER_LETTER;
    }

}
