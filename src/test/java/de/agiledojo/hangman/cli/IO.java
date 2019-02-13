package de.agiledojo.hangman.cli;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class IO {
    static void enter(String input) {

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    static ByteArrayOutputStream initializeStdOut() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        return baos;
    }
}