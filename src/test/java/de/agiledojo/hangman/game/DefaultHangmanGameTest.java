package de.agiledojo.hangman.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultHangmanGameTest {

    @Mock
    private Display display;

    @Test
    void showsPlaceHoldersWithoutMatchingLetter() {
        DefaultHangmanGame game = new DefaultHangmanGame("Secret",display);
        game.guess("a");
        verify(display).showBoard("------");
    }
}
