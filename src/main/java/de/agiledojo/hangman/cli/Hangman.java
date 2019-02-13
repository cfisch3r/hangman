package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.HangmanGame;

public class Hangman {


    public static void main(String[] args) {
        InputReader reader = compose(args[0]);
        while (reader.readNextInput()) {
        }
    }

    private static InputReader compose(String arg) {
        StdOutDisplay display = new StdOutDisplay();
        HangmanGame game = HangmanGame.create(arg,display);
        return new InputReader(game);
    }
}
