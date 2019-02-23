package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.HangmanGame;
import de.agiledojo.hangman.game.HangmanGame.Result;

import java.util.Optional;

import static de.agiledojo.hangman.game.HangmanGame.Result.DONE;

public class Hangman {


    private final InputReader reader;
    private final HangmanGame game;

    public static void main(String[] args) {
        Hangman hangman = new Hangman(args[0]);
        hangman.run();
    }

    private Hangman(String word) {
        StdOutDisplay display = new StdOutDisplay();
        game = HangmanGame.create(word,display);
        reader = new InputReader();
    }

    private void run() {
        Result result = null;
        do {
            Optional<String> line = reader.readNextInput();
            if (line.isPresent()) {
                result = game.guess(line.get());
            }
        } while (result != DONE);
    }

}
