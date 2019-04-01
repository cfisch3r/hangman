package de.agiledojo.hangman;

import de.agiledojo.hangman.test.MockStdIn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StdInputReaderTest {

    @Mock
    private HangmanGame game;

    @Test
    void readsLineFromStdInForNextGuess() {
        MockStdIn stdIn = MockStdIn.create();
        stdIn.enter("ö");
        StdInputReader reader = new StdInputReader(game);
        reader.read();
        verify(game).guess("ö");
    }
}
