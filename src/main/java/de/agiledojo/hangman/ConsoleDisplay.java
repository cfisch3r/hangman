package de.agiledojo.hangman;

public class ConsoleDisplay implements Display {
    @Override
    public void show(String board) {
        print(board);
    }

    @Override
    public void showResult(long numberOfFailures) {
        print("You won!");
        print(String.format("%d Failure(s)",numberOfFailures));
    }

    @Override
    public void showError(String reason) {
        print(String.format("Error: %s",reason));
    }


    private void print(String message) {
        System.out.println(message);
    }
}
