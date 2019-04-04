package de.agiledojo.hangman;

public class Hangman {
    public static void main(String[] args) {
        ConsoleDisplay display = new ConsoleDisplay();
        HangmanGame game = new DefaultHangmanGame(args[0],display);
        UserInputReader reader = new UserInputReader(game);
        while (true)
            reader.read();
    }
}
