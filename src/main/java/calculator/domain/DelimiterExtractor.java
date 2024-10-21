package calculator.domain;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String extract(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);
            return DEFAULT_DELIMITERS + "|" + customDelimiter;
        }
        return DEFAULT_DELIMITERS;
    }
}