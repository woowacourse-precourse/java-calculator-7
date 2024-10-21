package calculator.domain;

public enum CalculatorConstants {

    DEFAULT_DELIMITER_COMMA(","),
    DEFAULT_DELIMITER_COLON(":"),
    CUSTOM_DELIMITER_PREFIX("//"),
    CUSTOM_DELIMITER_SUFFIX("\\n");

    private final String value;

    CalculatorConstants(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
