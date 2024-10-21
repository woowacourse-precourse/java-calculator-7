package calculator.domain;

public class DelimiterExtractor {
    public String[] extract(String input) {
        String defaultDelimiters = ",|:";

        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n", 2);
            String customDelimiter = parts[0].substring(2);
            String numbers = parts.length > 1 ? parts[1] : "";

            String combinedDelimiters = defaultDelimiters + "|" + customDelimiter;

            return new String[] {combinedDelimiters, numbers};
        }

        return new String[] {defaultDelimiters, input};
    }
}