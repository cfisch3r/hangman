package de.agiledojo.hangman;

import de.agiledojo.hangman.test.MockStdIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserInputInterfaceTest {

    @Mock
    HangmanGame game;
    private MockStdIn stdIn;
    private UserInputReader reader;

    @BeforeEach
    void setUp() {
        stdIn = MockStdIn.create();
        reader = new UserInputReader(game);
    }

    @Test
    void readsNextGuessFromUserInput() {
        stdIn.enter("ö");
        reader.read();
        verify(game).guess("ö");
    }

    @Test
    void doesNotGuessWhenUserInputIsEmpty() {
        reader.read();
        verify(game,never()).guess(any());
    }

    @Test
    void readsSubsequentyleNextGuessesFromUserInput() {
        stdIn.enter("ö");
        stdIn.enter("q");
        reader.read();
        reader.read();
        InOrder inOrder = inOrder(game);
        inOrder.verify(game).guess("ö");
        inOrder.verify(game).guess("q");
    }
}
