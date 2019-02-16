package de.agiledojo.hangman.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.agiledojo.hangman.cli.IO.startApplicationWithArgument;


class HangmanAcceptanceTest {


    private IO io;
    private MockStdIn stdIn;

    @BeforeEach
    void setUp() {
        io = IO.create();
        stdIn = MockStdIn.create();
    }

    @Test
    void showsPlaceHoldersWhenWordDoesNotContainProvidedLetter() {
        startApplicationWithArgument("Secret");
        enter("q");
        io.assertOutputToBe("------\n");
    }

    @Test
    void showsMatchingLettersInBoard() {
        startApplicationWithArgument("Secret");
        enter("s");
        enter("e");
        io.assertOutputToBe("S-----\nSe--e-\n");
    }

    @Test
    void showsMessageWhenBoardIsComplete() {
        startApplicationWithArgument("TDD");
        enter("t");
        enter("d");
        io.assertOutputToBe("T--\nTDD\nYou won!\n");
    }

    private void enter(String s) {
        stdIn.enter(s);
    }

}
