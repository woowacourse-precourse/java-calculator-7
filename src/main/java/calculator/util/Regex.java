package calculator.util;

public enum Regex {
    ARITHMETIC_WITH_DEFAULT_DELIMITER("^(?!.*-0)[0-9\\-\\s,:]*$"),
    ARITHMETIC_WITH_CUSTOM_DELIMITER_PREFIX("^(?!.*-0)[0-9\\-\\s"),
    ARITHMETIC_WITH_CUSTOM_DELIMITER_SUFFIX("]*$"),
    OPEN("["),
    CLOSE("]"),
    WHITE_SPACE("\\s"),
    DEFAULT_DELIMITER_FORMAT("[,:]"),
    CUSTOM_DELIMITER_INVALID_FORMAT("[0-9\\-/]|\\\\(?!Q|E)"),
    DELIMITER_GROUP_FORMAT("^//(.*)\\\\n(.*)"),
    ;


    String regularExpression;

    Regex(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegex() {
        return regularExpression;
    }
}
