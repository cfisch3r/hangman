package de.agiledojo.hangman.test;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag( name="Overview Scenarios",
        description = "Hangman is a Game where the User has to guess a secret word." )
@Retention( RetentionPolicy.RUNTIME )
public @interface OverviewSpecification {
}
