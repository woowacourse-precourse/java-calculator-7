package calculator.model;

public class Expression {
    private static final String EMPTY_SECTION = "";
    private static final String FIRST_DELIMITER = "//";
    private static final String LAST_DELIMITER = "\\n";

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean hasCustomSeparator() {
        return expression.startsWith(FIRST_DELIMITER);
    }

    public String separatorSection() {
        if (hasCustomSeparator()) {
            int startIdx = expression.indexOf(FIRST_DELIMITER) + 2;
            int endIdx = expression.indexOf(LAST_DELIMITER);
            return expression.substring(startIdx, endIdx);
        }
        return EMPTY_SECTION;
    }

    public String nonSeparatorSection() {
        if (hasCustomSeparator()) {
            int startIdx = expression.indexOf(LAST_DELIMITER) + 2;
            return expression.substring(startIdx);
        }
        return expression;
    }
}
