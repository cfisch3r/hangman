package de.agiledojo.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
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
        inputs.add(input.toLowerCase());
        String board = createBoard(inputs);
        display.show(board);
        if (!board.contains(PLACEHOLDER_LETTER)) {
            display.showResult("You won!");
            display.showFailures(failures());
        }
    }

    private long failures() {
        return inputs.stream().filter(((i) -> !secret.toLowerCase().contains(i.toLowerCase()))).count();
    }

    private String createBoard(List<String> inputs) {
        return secret.chars().mapToObj(mapToBoardCharacter(inputs)).collect(Collectors.joining());
    }

    private IntFunction<String> mapToBoardCharacter(List<String> inputs) {
        return (c) -> {
            String letter = String.valueOf((char) c);
            return inputs.contains(letter.toLowerCase())? letter : PLACEHOLDER_LETTER;
        };
    }
}
