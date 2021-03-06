package de.agiledojo.hangman;

import com.tngtech.jgiven.junit5.JGivenExtension;
import de.agiledojo.hangman.test.InterfaceSpecification;
import de.agiledojo.hangman.test.MockStdIn;
import de.agiledojo.hangman.test.OutputListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith( JGivenExtension.class )
@InterfaceSpecification("Console Display")
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
        assertOutputToBe("xxxx" + lbr());
    }

    @Test
    void showsResult() {
        display.showResult(2);
        assertOutputToBe("You won!" + lbr() + "2 Failure(s)" +lbr());
    }

    @Test
    void showsError() {
        display.showError("Ein Fehler");
        assertOutputToBe("Error: Ein Fehler" + lbr());
    }

    private void assertOutputToBe(String text) {
        outputListener.assertOutputToBe(text);
    }

    private String lbr() {
        return MockStdIn.lineBreak();
    }


}
