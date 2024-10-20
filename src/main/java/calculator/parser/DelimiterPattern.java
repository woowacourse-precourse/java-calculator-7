package calculator.parser;

public enum DelimiterPattern {
    DEFAULT_DELIMITER(",|:"),
    CUSTOM_DELIMITER_PREFIX("//");

    private final String value;

    DelimiterPattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}