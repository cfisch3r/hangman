package de.agiledojo.hangman;

import java.util.stream.Collectors;

public class DefaultHangmanGame implements HangmanGame{
    private static final String PLACEHOLDER_LETTER = "-";
    private final String secret;
    private final Display display;
    private StringBuilder inputs = new StringBuilder();

    public DefaultHangmanGame(String secret, Display display) {
        this.secret = secret;
        this.display = display;
    }

    @Override
    public void guess(String input) {
        addInput(input);
        String board = createBoard();
        display.show(board);
        if (!isIncomplete())
            display.showResult(failures());
    }

    @Override
    public boolean isIncomplete() {
        return numberOfDifferentLetters(secret, inputs.toString()) > 0;
    }

    private void addInput(String input) {
        inputs.append(input);
    }

    private long failures() {
        return numberOfDifferentLetters(inputs.toString(), secret);
    }

    private long numberOfDifferentLetters(String a, String b) {
        return a.toLowerCase().chars()
                .filter(((c) -> !b.toLowerCase().contains(letter(c))))
                .count();
    }

    private String letter(int c) {
        return String.valueOf((char) c);
    }

    private String createBoard() {
        return secret.chars().mapToObj(this::mapToBoardSymbol).collect(Collectors.joining());
    }

    private String mapToBoardSymbol(int character) {
        String letter = letter(character);
        return inputs.toString().toLowerCase().contains(letter.toLowerCase())? letter : PLACEHOLDER_LETTER;
    }

}
