package de.agiledojo.hangman.cli;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

class StdOutDisplayIntegrationTest {

    @Test
    void showsBoard() {
        ByteArrayOutputStream stdOut = IO.initializeStdOut();
        StdOutDisplay display = new StdOutDisplay();
        display.showBoard("---");
        assertThat(stdOut.toString()).isEqualTo("---\n");
    }

}
