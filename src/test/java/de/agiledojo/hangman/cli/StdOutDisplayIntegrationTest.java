package de.agiledojo.hangman.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

class StdOutDisplayIntegrationTest {

    private ByteArrayOutputStream stdOut;
    private StdOutDisplay display;

    @BeforeEach
    void setUp() {
        stdOut = IO.initializeStdOut();
        display = new StdOutDisplay();
    }

    @Test
    void showsBoard() {
        display.showBoard("---");
        assertThat(stdOut.toString()).isEqualTo("---\n");
    }

    @Test
    void showsMessage() {
        display.showMessage("You won!");
        assertThat(stdOut.toString()).isEqualTo("You won!\n");
    }
}
