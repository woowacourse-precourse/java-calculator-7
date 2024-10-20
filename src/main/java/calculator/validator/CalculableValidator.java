package calculator.validator;

import calculator.common.Delimiters;
import calculator.enums.ErrorMessage;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculableValidator {
    private static final String DELIMITER_REGEX_OR_OPERATOR = "|";
    private static final String VALID_PATTERN_TEMPLATE = "^[0-9%s]+$";

    private CalculableValidator() {
    }

    public static void validateAllowedDelimiters(String input, Delimiters delimiters) {
        Set<String> allDelimiters = delimiters.getDelimiters();

        String delimiterPattern = allDelimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining(DELIMITER_REGEX_OR_OPERATOR));

        String validPattern = String.format(VALID_PATTERN_TEMPLATE, delimiterPattern);

        if (!Pattern.matches(validPattern, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_INCLUDED.getMessage());
        }
    }
}
