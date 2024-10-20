package calculator.constant;

public enum Delimiter {
    COMMA(","),
    COLON(":"),
    CUSTOM_DELIMITER_PREFIX("//"),
    CUSTOM_DELIMITER_SUFFIX("\\n");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
