package calculator.domain;

import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] extract(String input) {
        if (input.startsWith("//")) {
            return extractCustomDelimiter(input);
        }
        return new String[] {DEFAULT_DELIMITERS, input};
    }

    private String[] extractCustomDelimiter(String input) {
        String[] parts = input.split("\\\\n", 2);
        String customDelimiter = parts[0].substring(2);
        String numbers = parts.length > 1 ? parts[1] : "";

        String combinedDelimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
        return new String[] {combinedDelimiters, numbers};
    }
}