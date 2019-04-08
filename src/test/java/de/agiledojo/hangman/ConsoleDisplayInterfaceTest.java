package de.agiledojo.hangman;

import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsoleDisplayInterfaceTest {

    private OutputListener outputListener;
    private ConsoleDisplay display;

    @BeforeEach
    void setUp() {
        outputListener = OutputListener.create();
        display = new ConsoleDisplay();
    }

    @Test
    void showsBoard() {
        display.show("xxxx");
        outputListener.assertOutputToBe("xxxx\n");
    }

    @Test
    void showsResult() {
        display.showResult(2);
        outputListener.assertOutputToBe("You won!\n2 Failure(s)\n");
    }
}
