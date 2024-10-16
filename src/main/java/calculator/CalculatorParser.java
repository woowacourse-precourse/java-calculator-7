package calculator;

public class CalculatorParser {
    private static final int CUSTOM_DELIMITER_LENGTH = 1;
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";

    private String customDelimiter = "";
    private final String expression;

    public CalculatorParser(String line) {
        int expressionStartIdx = 0;

        if (hasCustomDelimiter(line)) {
            parseCustomDelimiter(line);
            checkCustomDelimiterEnd(line);
            expressionStartIdx = CUSTOM_START.length() + CUSTOM_DELIMITER_LENGTH + CUSTOM_END.length(); // TODO: 포맷하기
        }

        this.expression = line.substring(expressionStartIdx);
    }

    private void parseCustomDelimiter(String line) {
        this.customDelimiter = line.charAt(CUSTOM_START.length()) + "";
    }

    private void checkCustomDelimiterEnd(String line) {
        int customEndStart = CUSTOM_START.length() + CUSTOM_DELIMITER_LENGTH;

        if (!line.startsWith(CUSTOM_END, customEndStart)) { // CUSTOM_END로 끝나지 않는다면
            throw new IllegalArgumentException();
        }
    }

    private boolean hasCustomDelimiter(String line) {
        return line.startsWith(CUSTOM_START);
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }

    public String getExpression() {
        return expression;
    }
}
