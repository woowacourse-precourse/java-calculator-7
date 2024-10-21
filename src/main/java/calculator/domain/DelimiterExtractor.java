package calculator.domain;

import java.util.regex.Pattern;

public class DelimiterExtractor {

    public String extractDelimiters(String input, String defaultDelimiters, String customDelimiterStart,
                                    String customDelimiterEnd) {
        String delimiters = defaultDelimiters;
        String customDelimiter = extractCustomDelimiter(input, customDelimiterStart, customDelimiterEnd);
        if (!customDelimiter.isEmpty()) {
            delimiters += "|" + Pattern.quote(customDelimiter);
        }
        System.out.println(delimiters);
        return delimiters;
    }

    private String extractCustomDelimiter(String input, String customDelimiterStart, String customDelimiterEnd) {
        int startIndex = input.indexOf(customDelimiterStart);
        int endIndex = input.indexOf(customDelimiterEnd);

        if (startIndex != -1 && endIndex != -1) {
            return input.substring(startIndex + customDelimiterStart.length(), endIndex);
        }
        return "";
    }
}
