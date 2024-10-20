package calculator.model;

import calculator.exception.ExceptionMessages;

public class StringSplitter {

    private final DelimiterParser delimiterParser;

    public StringSplitter(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public String[] split(String input) {

        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        String numbers = input;

        String customDelimiter = delimiterParser.parseCustomDelimiter(input);
        if (customDelimiter != null) {
            delimiter = customDelimiter;
            int delimiterEndIndex = input.indexOf("\\n");
            numbers = input.substring(delimiterEndIndex + 2);
        }

        if (!numbers.matches("[-\\d" + delimiter + "]+")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DELIMITER_ERROR);
        }

        String[] splitNumbers = numbers.split(delimiter);

        if (splitNumbers.length == 0 || numbers.matches(delimiter + "+")) {
            throw new IllegalArgumentException(ExceptionMessages.MISSING_NUMBER_ERROR);
        }

        return splitNumbers;
    }
}