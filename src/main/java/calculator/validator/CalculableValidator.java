package calculator.validator;

import calculator.common.Delimiters;
import calculator.enums.ErrorMessage;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculableValidator {
    private static final String DELIMITER_REGEX_OR_OPERATOR = "|";
    private static final String VALID_PATTERN_TEMPLATE = "^[0-9%s]+$";
    private static final String VALID_PATTERN_DELIMITER_BETWEEN_NUMBERS_TEMPLATE = "^(\\d+[%s])+\\d+$";


    private CalculableValidator() {
    }

    public static void validateAllowedDelimiters(String input, Delimiters delimiters) {
        String delimiterPattern = buildDelimiterPattern(delimiters);
        String validPattern = String.format(VALID_PATTERN_TEMPLATE, delimiterPattern);

        if (!Pattern.matches(validPattern, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_INCLUDED.getMessage());
        }
    }

    public static void validateDelimiterPosition(String input, Delimiters delimiters) {
        String delimiterPattern = buildDelimiterPattern(delimiters);
        String positionPattern = String.format(VALID_PATTERN_DELIMITER_BETWEEN_NUMBERS_TEMPLATE, delimiterPattern);

        if (!Pattern.matches(positionPattern, input)) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_MUST_BE_BETWEEN_NUMBERS.getMessage());
        }
    }

    public static void validateNumberSize(String input, Delimiters delimiters) {
        String delimiterPattern = buildDelimiterPattern(delimiters);
        String[] numbers = input.split(delimiterPattern);

        for (String number : numbers) {
            try {
                Long.parseLong(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_TOO_LARGE.getMessage());
            }
        }
    }

    private static String buildDelimiterPattern(Delimiters delimiters) {
        Set<String> allDelimiters = delimiters.getDelimiters();
        return allDelimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining(DELIMITER_REGEX_OR_OPERATOR));
    }
}
