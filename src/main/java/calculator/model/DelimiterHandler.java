package calculator.model;

public class DelimiterHandler {

    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";

    private static final int CUSTOM_START_INDEX = 0;
    private static final int CUSTOM_END_INDEX = 3;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    private String delimiters = ",:";
    private boolean customDelimiterFlag = false;

    public DelimiterHandler(String expression) {
        setDelimiter(expression);
    }

    private void setDelimiter(String expression) {
        if (checkDelimiter(expression)) {
            delimiters += expression.charAt(CUSTOM_DELIMITER_INDEX);
            customDelimiterFlag = true;
        }
    }

    private boolean checkDelimiter(String expression) {
        if (expression.indexOf(CUSTOM_START) == CUSTOM_START_INDEX
                && expression.indexOf(CUSTOM_END) == CUSTOM_END_INDEX) {
            return true;
        }
        return false;
    }

    public String getAllDelimiters() {
        return delimiters;
    }

    public boolean getCustomDelimiterFlag() {
        return customDelimiterFlag;
    }

}
