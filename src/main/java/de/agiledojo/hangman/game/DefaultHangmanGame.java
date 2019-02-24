package de.agiledojo.hangman.game;

import java.util.function.IntFunction;
import java.util.stream.Collectors;

class DefaultHangmanGame implements HangmanGame {
    private static final String PLACEHOLDER = "-";
    private static final String WINNING_MESSAGE = "You won!";
    private final String word;
    private final Display display;
    private String guessedLetters;

    DefaultHangmanGame(String word, Display display) {
        this.word = word;
        this.display = display;
    }

    @Override
    public Result guess(String letter) {
        guessedLetters += letter.toLowerCase();
        String board = createBoard();
        display.showBoard(board);
        if (!board.contains(PLACEHOLDER)) display.showMessage(WINNING_MESSAGE);

        return board.contains(PLACEHOLDER)? Result.INCOMPLETE : Result.DONE;
    }

    private String createBoard() {
        return word.chars().mapToObj(characterToBoardDigit()).collect(Collectors.joining());
    }

    private IntFunction<String> characterToBoardDigit() {
        return character -> {
            String letter = String.valueOf((char) character);
            return guessedLetters.contains(letter.toLowerCase())? letter : PLACEHOLDER;
        };
    }
}
