package de.agiledojo.hangman;

import de.agiledojo.hangman.test.ApplicationRunner;
import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.Test;

public class HangmanAcceptanceTest {

    @Test
    void boardHasOnlyPlaceHolderWhenInputDoesNotMatch() {
        MockStdIn mockStdIn = MockStdIn.create();
        OutputListener outputListener = OutputListener.create();
        ApplicationRunner.startApplicationWithArgument(Hangman::main,"Secret");
        mockStdIn.enter("ö");
        outputListener.assertOutputToBe("------\n");
    }
}
