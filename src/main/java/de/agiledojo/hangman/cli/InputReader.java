package de.agiledojo.hangman.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

class InputReader {
    private BufferedReader reader;

    InputReader() {
        reader = createStdInReader();
    }

    Optional<String> nextLine() {
        return Optional.ofNullable(readLine());
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
