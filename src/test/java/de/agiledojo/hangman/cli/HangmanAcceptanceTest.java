package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.agiledojo.hangman.test.ApplicationRunner.startApplicationWithArgument;


class HangmanAcceptanceTest {


    private OutputListener outputListener;
    private MockStdIn stdIn;

    @BeforeEach
    void setUp() {
        outputListener = OutputListener.create();
        stdIn = MockStdIn.create();
    }

    @Test
    void showsPlaceHoldersWhenWordDoesNotContainProvidedLetter() {
        startApplicationWithArgument("Secret");
        enter("q");
        assertOutputToBe("------\n");
    }

    @Test
    void showsMatchingLettersInBoard() {
        startApplicationWithArgument("Secret");
        enter("s").enter("e");
        assertOutputToBe("S-----\nSe--e-\n");
    }

    @Test
    void showsMessageWhenBoardIsComplete() {
        startApplicationWithArgument("TDD");
        enter("t").enter("d");
        assertOutputToBe("T--\nTDD\nYou won!\n");
    }

    private HangmanAcceptanceTest enter(String s) {
        stdIn.enter(s);
        return this;
    }

    private void assertOutputToBe(String expectedOutput) {
        outputListener.assertOutputToBe(expectedOutput);
    }
}
