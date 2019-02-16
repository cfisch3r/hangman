package de.agiledojo.hangman.cli;

import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StdOutDisplayIntegrationTest {

    private StdOutDisplay display;
    private OutputListener output;

    @BeforeEach
    void setUp() {
        output = OutputListener.create();
        display = new StdOutDisplay();
    }

    @Test
    void showsBoard() {
        display.showBoard("---");
        output.assertOutputToBe("---\n");
    }

    @Test
    void showsMessage() {
        display.showMessage("You won!");
        output.assertOutputToBe("You won!\n");
    }
}
