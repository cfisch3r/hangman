package de.agiledojo.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class UserInputReader {
    private HangmanGame game;
    private BufferedReader reader;

    public UserInputReader(HangmanGame game) {
        this.game = game;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void read() {
        readLine().ifPresent(game::guess);
    }

    private Optional<String> readLine() {
        try {
            return Optional.ofNullable(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
