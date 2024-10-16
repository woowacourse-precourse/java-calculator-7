package calculator.domain.vo.delimiter.constants;

public enum DelimiterPattern {
    COMMA(","),
    COLON(":"),
    EMPTY(""),
    CUSTOM_DELIMITER_PREFIX("//"),
    CUSTOM_DELIMITER_SUFFIX("\n");

    private final String value;

    DelimiterPattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
