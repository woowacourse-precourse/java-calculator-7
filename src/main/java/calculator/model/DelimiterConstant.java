package calculator.model;

public enum DelimiterConstant {
    CUSTOM_VALIDATOR_PREFIX("//"),
    CUSTOM_VALIDATOR_EXPRESSION_LENGTH("5"),
    VALIDATOR_COMMA(","),
    VALIDATOR_COLON(":");

    DelimiterConstant(final String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
