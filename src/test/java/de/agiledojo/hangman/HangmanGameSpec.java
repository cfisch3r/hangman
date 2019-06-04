package de.agiledojo.hangman;

import com.tngtech.jgiven.junit5.JGivenExtension;
import de.agiledojo.hangman.test.UseCaseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(JGivenExtension.class)
@UseCaseSpecification("Play Hangman Game")
public class HangmanGameSpec {

    @Mock
    private Display display;
    private DefaultHangmanGame game;

    @BeforeEach
    void setUp() {
        game = new DefaultHangmanGame("Secret",display);
    }

}
