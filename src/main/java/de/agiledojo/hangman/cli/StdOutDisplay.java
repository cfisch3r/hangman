package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.game.Display;

public class StdOutDisplay implements Display {
    @Override
    public void showBoard(String board) {
        System.out.println(board);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
