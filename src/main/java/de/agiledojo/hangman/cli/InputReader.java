package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.HangmanGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputReader {
    private HangmanGame hangmanGame;
    private BufferedReader reader;

    InputReader(HangmanGame hangmanGame) {
        this.hangmanGame = hangmanGame;
        reader = createStdInReader();
    }

    void readNextInput() {
        String line = readLine();
        if (line != null)
            hangmanGame.guess(line);
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader createStdInReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
