package calculator.util;

public enum Limit {
    MAX_DIGIT_LENGTH(30),
    MAX_NUMBER(1000),
    MIN_NUMBER(0),
    MAX_CUSTOM_DELIMITER(3),
    REGEX_ESCAPE_CORRECTION(4),
    ;

    int value;

    Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
