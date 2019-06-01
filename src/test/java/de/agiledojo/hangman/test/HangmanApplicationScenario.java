package de.agiledojo.hangman.test;

import com.tngtech.jgiven.Stage;
import de.agiledojo.hangman.Hangman;

public class HangmanApplicationScenario extends Stage<HangmanApplicationScenario> {

    private MockStdIn mockStdIn;
    private OutputListener outputListener;
    private ApplicationRunner.ApplicationStatus applicationStatus;



    public HangmanApplicationScenario Application_started_with_Secret(String secret) {
        mockStdIn = MockStdIn.create();
        outputListener = OutputListener.create();
        applicationStatus = ApplicationRunner.startApplicationWithArgument(Hangman::main, secret);
        return self();
    }

    public HangmanApplicationScenario entering(String line) {
        mockStdIn.enter(line);
        return self();
    }

    public HangmanApplicationScenario Output_contains(String output) {
        outputListener.assertOutputToContain(output);
        return self();
    }

    public HangmanApplicationScenario Application_exits_within(int milliSeconds) {
        applicationStatus.assertToBeFinishedWithin(milliSeconds);
        return self();
    }

    public HangmanApplicationScenario Output_contains_Line(String line) {
        return Output_contains(line + MockStdIn.lineBreak());
    }

}
