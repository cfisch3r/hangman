package de.agiledojo.hangman;

import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.Test;

public class ConsoleDisplayInterfaceTest {

    @Test
    void showsBoardOnStdOut() {
        OutputListener outputListener = OutputListener.create();
        ConsoleDisplay display = new ConsoleDisplay();
        display.show("xxxx");
        outputListener.assertOutputToBe("xxxx\n");
    }
}
