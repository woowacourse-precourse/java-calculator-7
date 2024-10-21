package calculator.model;

import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);

            if (parts.length != 2) {
                throw new IllegalArgumentException();
            }

            String customDelimiter = parts[0].substring(2);
            return parts[1].split(Pattern.quote(customDelimiter));
        }

        return input.split(DEFAULT_DELIMITERS);
    }
}