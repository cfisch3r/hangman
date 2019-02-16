package de.agiledojo.hangman.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.agiledojo.hangman.cli.IO.enter;
import static de.agiledojo.hangman.cli.IO.startApplicationWithArgument;


class HangmanAcceptanceTest {


    private IO io;

    @BeforeEach
    void setUp() {
        io = IO.create();
    }

    @Test
    void showsPlaceHoldersWhenWordDoesNotContainProvidedLetter() {
        enter("q");
        startApplicationWithArgument("Secret");
        io.assertOutputToBe("------\n");
    }

    @Test
    void showsMatchingLettersInBoard() {
        enter("s\ne");
        startApplicationWithArgument("Secret");
        io.assertOutputToBe("S-----\nSe--e-\n");
    }

    @Test
    void showsMessageWhenBoardIsComplete() {
        enter("t\nd\n");
        startApplicationWithArgument("TDD");
        io.assertOutputToBe("T--\nTDD\nYou won!\n");
    }

}
