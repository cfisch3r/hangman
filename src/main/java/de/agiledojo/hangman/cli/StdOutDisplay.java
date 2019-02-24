package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.Display;

public class StdOutDisplay implements Display {
    @Override
    public void showBoard(String board) {
        print(board);
    }

    @Override
    public void showMessage(String message) {
        print(message);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
