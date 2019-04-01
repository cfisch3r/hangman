package de.agiledojo.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInputReader {
    private HangmanGame game;

    public StdInputReader(HangmanGame game) {
        this.game = game;
    }

    public void read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        game.guess(read(reader));
    }

    private String read(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
