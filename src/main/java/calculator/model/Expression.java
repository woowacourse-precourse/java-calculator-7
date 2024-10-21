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
        if (!hasCustomSeparator()) {
            return EMPTY_SECTION;
        }
        int startIdx = expression.indexOf(FIRST_DELIMITER) + 2;
        int endIdx = expression.indexOf(LAST_DELIMITER);
        return expression.substring(startIdx, endIdx);
    }

    public String nonSeparatorSection() {
        if (!hasCustomSeparator()) {
            return expression;
        }
        int startIdx = expression.indexOf(FIRST_DELIMITER) + 2;
        return expression.substring(startIdx);
    }
}
