package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.Context;
import de.agiledojo.hangman.game.HangmanGame;

public class Hangman implements Context {


    private final InputReader reader;
    private boolean completed = false;

    public static void main(String[] args) {
        Hangman hangman = new Hangman(args[0]);
        hangman.run();
    }

    public Hangman(String word) {
        reader = compose(word,this);
    }

    private static InputReader compose(String arg, Hangman hangman) {
        StdOutDisplay display = new StdOutDisplay();
        HangmanGame game = HangmanGame.create(arg,display,hangman);
        return new InputReader(game);
    }

    private void run() {
        while (!completed) {
            reader.readNextInput();
        }
    }

    @Override
    public void stop() {
        completed = true;
    }
}
