package de.agiledojo.hangman;

public class ConsoleDisplay implements Display{
    @Override
    public void show(String board) {
        System.out.println(board);
    }
}
