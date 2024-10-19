package calculator;

public class StringDivider {
    private static final String DEFAULT_SEPARATOR = ":|,";
    private final String separator;

    private final String mathExpression;

    public StringDivider(String mathExpression) {
        this.separator = DEFAULT_SEPARATOR;
        this.mathExpression = mathExpression;
    }

    public StringDivider(String customSeparator, String mathExpression) {
        this.separator = DEFAULT_SEPARATOR + "|" + customSeparator;
        this.mathExpression = mathExpression;
    }

    public String[] divideStringBy() {
        return mathExpression.split(this.separator);
    }
}
