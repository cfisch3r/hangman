package de.agiledojo.hangman.test;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag( name="Interface Specification",
        description = "Hangman Interfaces",
        prependType = true)
@Retention( RetentionPolicy.RUNTIME )
public @interface InterfaceSpecification {
    String value();
}
