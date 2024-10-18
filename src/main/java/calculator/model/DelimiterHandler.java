package calculator.model;

public class DelimiterHandler {

    private final String customStart = "//";
    private final String customEnd = "\\n";

    private String delimiters = ",:";
    private boolean customDelimiterFlag = false;

    private boolean checkDelimiter(String expression) {
        if (expression.indexOf(customStart) == 0 && expression.indexOf(customEnd) == 3){
            return true;
        }
        return false;
    }

    public void setDelimiter(String expression) {
            if (checkDelimiter(expression)) {
                delimiters += expression.charAt(2);
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
