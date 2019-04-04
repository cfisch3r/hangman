package de.agiledojo.hangman;

import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class DefaultHangmanGame implements HangmanGame{
    private static final String PLACEHOLDER_LETTER = "-";
    private final String secret;
    private final Display display;

    public DefaultHangmanGame(String secret, Display display) {
        this.secret = secret;
        this.display = display;
    }

    @Override
    public void guess(String input) {
        display.show(createBoard(input));
    }

    private String createBoard(String input) {
        return secret.chars().mapToObj(mapToBoardCharacter(input)).collect(Collectors.joining());
    }

    private IntFunction<String> mapToBoardCharacter(String input) {
        return (c) -> {
            String letter = String.valueOf((char) c);
            return letter.equalsIgnoreCase(input)? letter : PLACEHOLDER_LETTER;
        };
    }
}
