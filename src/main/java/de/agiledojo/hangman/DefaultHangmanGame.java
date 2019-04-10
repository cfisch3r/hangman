package de.agiledojo.hangman;

public class DefaultHangmanGame implements HangmanGame{
    private final String secret;
    private final Display display;
    private String inputs = "";
    private final Board board;

    public DefaultHangmanGame(String secret, Display display) {
        this.secret = secret;
        this.display = display;
        board = new Board(secret,display);
    }

    @Override
    public void guess(String input) {
        processInput(input);
        board.show(inputs);
        if (isComplete())
            display.showResult(failures());
    }

    @Override
    public boolean isComplete() {
        return numberOfDifferentLetters(secret, inputs) == 0;
    }

    private void processInput(String input) {
        if (input.length() > 1) {
            display.showError("Only single letters are allowed.");
        } else if (input.length() == 0) {
            display.showError("You must enter a letter.");
        } else {
          inputs += input;
        }
    }

    private long failures() {
        return numberOfDifferentLetters(inputs, secret);
    }

    private long numberOfDifferentLetters(String a, String b) {
        return a.toLowerCase().chars()
                .filter(((c) -> !b.toLowerCase().contains(String.valueOf((char) c))))
                .count();
    }

}
