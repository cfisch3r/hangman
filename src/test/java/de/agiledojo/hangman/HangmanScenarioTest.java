package de.agiledojo.hangman;

import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit5.JGivenExtension;
import de.agiledojo.hangman.test.HangmanApplicationScenario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith( JGivenExtension.class )
class HangmanScenarioTest {

    @ScenarioStage
    private HangmanApplicationScenario scenario;

    @Test
    void user_can_enter_Guesses_and_see_the_current_Status() {
        scenario
            .given().Application_started_with_Secret("Secret")
            .when().entering("s")
            .and().entering("e")
            .then().Output_contains("S-----")
            .and().Output_contains("Se--e-");
    }

    @Test
    void user_sees_result_when_Game_is_finished() {
        scenario
            .given().Application_started_with_Secret("Secret")
            .when().entering("s")
            .and().entering("e")
            .and().entering("x")
            .and().entering("c")
            .and().entering("r")
            .and().entering("t")
            .then().Output_contains("You won!")
            .and().Output_contains("1 Failure(s)")
            .and().Application_exits_within(100);
    }

    @Test
    void user_gets_an_Error_Message_for_wrong_input() {
        scenario
            .given().Application_started_with_Secret("Secret")
            .when().entering("abc")
            .then().Output_contains_Line("Error: Only single letters are allowed.");
    }

}
