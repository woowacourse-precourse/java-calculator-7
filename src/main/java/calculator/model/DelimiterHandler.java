package calculator.model;

public class DelimiterHandler {

    private static final int customStartIndex = 0;
    private static final int customEndIndex = 3;
    private static final int customDelimIndex = 2;

    private static final String customStart = "//";
    private static final String customEnd = "\\n";

    private String delimiters = ",:";
    private boolean customDelimiterFlag = false;

    private boolean checkDelimiter(String expression) {
        if (expression.indexOf(customStart) == customStartIndex && expression.indexOf(customEnd) == customEndIndex) {
            return true;
        }
        return false;
    }

    public void setDelimiter(String expression) {
            if (checkDelimiter(expression)) {
                delimiters += expression.charAt(customDelimIndex);
                customDelimiterFlag = true;
            }
    }

    public String getAllDelimiters() {
        return delimiters;
    }

    public boolean getCustomDelimiterFlag() {
        return customDelimiterFlag;
    }

}
