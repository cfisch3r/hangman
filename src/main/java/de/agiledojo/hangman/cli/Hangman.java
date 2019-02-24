package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.HangmanGame;
import de.agiledojo.hangman.game.HangmanGame.Result;

import static de.agiledojo.hangman.game.HangmanGame.Result.DONE;

public class Hangman {


    private final InputReader reader;
    private final HangmanGame game;
    private Result lastGuessResult;

    public static void main(String[] args) {
        Hangman hangman = new Hangman(args[0]);
        hangman.run();
    }

    private Hangman(String word) {
        reader = new InputReader();
        game = HangmanGame.create(word, new StdOutDisplay());
    }

    private void run() {
        while (lastGuessResult != DONE) {
            nextTurn();
        }
    }

    private void nextTurn() {
        reader.nextLine().ifPresent(line -> lastGuessResult = game.guess(line));
    }


}
