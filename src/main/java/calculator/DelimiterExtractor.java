package calculator;

import static calculator.LiteralString.INVALID_CUSTOM_DELIMITER;

class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private final String input;
    private String delimiter;
    private String numbers;

    public DelimiterExtractor(String input) {
        this.input = input;
        extractDelimiterAndNumbers();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getNumbers() {
        return numbers;
    }

    private void extractDelimiterAndNumbers() {
        if (input.startsWith("//")) {
            int customDelimiterEndIndex = input.indexOf("\n");
            if (customDelimiterEndIndex == -1) {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
            }
            int customDelimiterStartIndex = input.indexOf("//");
            this.delimiter = input.substring(customDelimiterStartIndex, customDelimiterEndIndex).trim();
            this.numbers = input.substring(customDelimiterEndIndex + 1);
        } else {
            this.delimiter = DEFAULT_DELIMITERS;
            this.numbers = input;
        }
    }
}