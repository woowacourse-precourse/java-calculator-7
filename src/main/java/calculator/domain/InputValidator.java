package calculator.domain;

import static calculator.constants.InputValidationConstants.CUSTOM_DELIMITER_PATTERN_PREFIX;
import static calculator.constants.InputValidationConstants.CUSTOM_DELIMITER_PATTERN_SUFFIX;
import static calculator.constants.InputValidationConstants.CONTAINS_NUMBERS_PATTERN;
import static calculator.constants.InputValidationConstants.INVALID_INPUT_EXCEPTION_MESSAGE;
import static calculator.constants.InputValidationConstants.NORMAL_DELIMITER_INPUT_PATTERN;

import java.util.regex.Pattern;

public class InputValidator {
    public static void validate(String input){
        if(Parser.hasCustomDelimiter(input)){
            String delimiter = Parser.extractCustomDelimiter(input);

            validateCustomDelimiterForm(delimiter);
            validateInputWithCustomDelimiter(input, delimiter);
        }
        else
            validateInputWithNormalDelimiter(input);
    }

    private static void validateInputWithCustomDelimiter(String input, String delimiter) {
        String escapedDelimiter = Pattern.quote(delimiter);
        String pattern = CUSTOM_DELIMITER_PATTERN_PREFIX + escapedDelimiter + CUSTOM_DELIMITER_PATTERN_SUFFIX;
        if (!Pattern.matches(pattern, input.substring(delimiter.length()+4)))
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
    }

    private static void validateCustomDelimiterForm(String delimiter) {
        if (delimiter.isEmpty() || Pattern.matches(CONTAINS_NUMBERS_PATTERN, delimiter))
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
    }

    private static void validateInputWithNormalDelimiter(String input) {
        if(input.isEmpty())
            return;

        String cleanedInput = input.replace(" ", "");
        if(!Pattern.matches(NORMAL_DELIMITER_INPUT_PATTERN, cleanedInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
