package calculator;

public class DelimiterSelector {
    private boolean isCustomDelimiter(String input) {
        char firstChar = input.charAt(0);
        return !Character.isDigit(firstChar);
    }
}
