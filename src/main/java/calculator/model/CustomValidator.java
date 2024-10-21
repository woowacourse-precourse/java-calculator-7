package calculator.model;

import java.util.regex.Matcher;

import static calculator.constant.DelimiterConstants.DEFAULT_DELIMITER_REGEX;
import static calculator.constant.ErrorMessages.*;

public class CustomValidator implements Validator{

    private final Matcher matcher;

    public CustomValidator(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public ParsedInput validate(String input) {
        String delimiter = extractDelimiter();
        String numbersWithDelimiter = matcher.group(2);

        String delimiterRegex = buildDelimiterRegex(delimiter);
        String[] numbers = numbersWithDelimiter.split(delimiterRegex);

        validateNumbers(numbers);

        return new ParsedInput(delimiterRegex, numbersWithDelimiter);
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }

            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
            }
        }
    }

    private String buildDelimiterRegex(String delimiter) {
        return DEFAULT_DELIMITER_REGEX.substring(0, DEFAULT_DELIMITER_REGEX.length() - 1)
                + delimiter + "]";
    }

    private String extractDelimiter() {
        String delimiter = matcher.group(1);
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException(CUSTOM_DELIMITER_NOT_FOUND);
        }
        return delimiter;
    }
}
