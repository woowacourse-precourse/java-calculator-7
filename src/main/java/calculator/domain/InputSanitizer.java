package calculator.domain;

public class InputSanitizer {

    public String sanitizeInput(String input, String customDelimiterStart, String customDelimiterEnd) {
        int startDelimiterIndex = input.indexOf(customDelimiterStart);
        int endDelimiterIndex = input.indexOf(customDelimiterEnd);

        if (hasDelimiters(startDelimiterIndex, endDelimiterIndex)) {
            if (isStartDelimiterFirst(startDelimiterIndex, endDelimiterIndex)) {
                return removeAfterEndDelimiter(input, endDelimiterIndex, customDelimiterEnd);
            }

            if (isEndDelimiterFirst(endDelimiterIndex, startDelimiterIndex)) {
                return removeAfterStartDelimiter(input, startDelimiterIndex, customDelimiterStart);
            }
        }

        return input;
    }

    private boolean hasDelimiters(int startDelimiterIndex, int endDelimiterIndex) {
        return startDelimiterIndex != -1 || endDelimiterIndex != -1;
    }

    private boolean isStartDelimiterFirst(int startDelimiterIndex, int endDelimiterIndex) {
        return startDelimiterIndex == 0 && endDelimiterIndex != -1 && endDelimiterIndex > startDelimiterIndex;
    }

    private boolean isEndDelimiterFirst(int endDelimiterIndex, int startDelimiterIndex) {
        return endDelimiterIndex == 0 && startDelimiterIndex != -1 && startDelimiterIndex > endDelimiterIndex;
    }

    private String removeAfterEndDelimiter(String input, int endDelimiterIndex, String customDelimiterEnd) {
        return input.substring(endDelimiterIndex + customDelimiterEnd.length());
    }

    private String removeAfterStartDelimiter(String input, int startDelimiterIndex, String customDelimiterStart) {
        return input.substring(startDelimiterIndex + customDelimiterStart.length());
    }
}
