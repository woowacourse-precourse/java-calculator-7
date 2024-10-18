package calculator.enums;

public enum Delimiter {

    CUSTOM_FIRST_DELIMITER("//"),
    CUSTOM_SECOND_DELIMITER("\n"),
    DEFAULT_DELIMITERS(",|:");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String toString() {
        return delimiter;
    }
}
