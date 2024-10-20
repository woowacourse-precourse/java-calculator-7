package calculator;

public class CalculatorParser {
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final int CUSTOM_LENGTH = 1;
    private static final int CUSTOM_START_INDEX = CUSTOM_PREFIX.length();
    private static final int CUSTOM_END_INDEX = CUSTOM_START_INDEX + CUSTOM_LENGTH;
    private static final int TOTAL_CUSTOM_LENGTH = CUSTOM_END_INDEX + CUSTOM_SUFFIX.length();

    private String customDelimiter = "";
    private final String expression;

    public CalculatorParser(String line) {
        int expressionStartIndex = 0;

        if (hasCustomDelimiter(line)) {
            this.customDelimiter = line.substring(CUSTOM_START_INDEX, CUSTOM_END_INDEX);
            expressionStartIndex = TOTAL_CUSTOM_LENGTH;
        }

        this.expression = line.substring(expressionStartIndex);
    }

    private static boolean hasCustomDelimiter(String line) {
        if (line.length() < TOTAL_CUSTOM_LENGTH) {
            return false;
        }

        if (!line.startsWith(CUSTOM_PREFIX)) {
            return false;
        }

        if (!line.startsWith(CUSTOM_SUFFIX, CUSTOM_END_INDEX)) {
            return false;
        }

        return true;
    }

    public String getCustomDelimiter() {
        return this.customDelimiter;
    }

    public String getExpression() {
        return this.expression;
    }
}
