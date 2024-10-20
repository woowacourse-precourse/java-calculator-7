package calculator.model;

import calculator.exception.ExceptionMessages;
import java.util.regex.Pattern;

public class StringProcessor {
    private String parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException(ExceptionMessages.CUSTOM_DELIMITER_ERROR);
                }
                return Pattern.quote(customDelimiter);
            } else {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DELIMITER_FORMAT);
            }
        }
        return null;
    }

    public String[] StringSplitter(String input) {

        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        String numbers = input;

        String customDelimiter = parseCustomDelimiter(input);
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