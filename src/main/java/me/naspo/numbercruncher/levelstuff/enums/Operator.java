package me.naspo.numbercruncher.levelstuff.enums;

public enum Operator {
    //Enums with their assigned char.
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    //Holds the enum's char value.
    private final char charValue;

    //Constructor. Initializes charValue with the enum's value when called.
    Operator(char charValue) {
        this.charValue = charValue;
    }

    //Getter for the enum's char value.
    public char asChar() {
        return charValue;
    }


}
