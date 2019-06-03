package de.agiledojo.hangman.test;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag( name="Use Case",
        description = "Use Cases for Hangman Application",
        prependType = true)
@Retention( RetentionPolicy.RUNTIME )
public @interface UseCaseSpecification {
    String value();
}
