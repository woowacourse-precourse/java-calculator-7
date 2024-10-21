package calculator.domain;

public class InputSanitizer {

    public String sanitizeInput(String input, String customDelimiterStart, String customDelimiterEnd) {
        if (input.startsWith(customDelimiterStart)) {
            int newlineIndex = input.indexOf(customDelimiterEnd);
            if (newlineIndex != -1) {
                return input.substring(newlineIndex + customDelimiterEnd.length());
            }
        }
        return input;
    }
}
