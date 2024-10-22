package calculator.model.Handler;

import java.util.regex.Pattern;

public class DelimiterHandler {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String extractDelimiters(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        String customDelimiter = extractCustomDelimiter(input);

        if (!customDelimiter.isEmpty()) {
            delimiters += "|" + Pattern.quote(customDelimiter);
        }
        return delimiters;
    }

    private String extractCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\n");
            if (endIndex != -1) {
                return input.substring(2, endIndex);
            }
        }
        return "";
    }

    public String sanitizeInput(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex != -1) {
                return input.substring(newlineIndex + 1);
            }
        }
        return input;
    }
}
