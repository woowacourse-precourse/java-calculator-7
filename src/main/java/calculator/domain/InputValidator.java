package calculator.domain;

import calculator.constants.InputValidationConstants;
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
        String pattern = InputValidationConstants.CUSTOM_DELIMITER_PATTERN_PREFIX + escapedDelimiter + InputValidationConstants.CUSTOM_DELIMITER_PATTERN_SUFFIX;
        if (!Pattern.matches(pattern, input.substring(delimiter.length()+4)))
            throw new IllegalArgumentException(InputValidationConstants.INVALID_INPUT_EXCEPTION_MESSAGE);
    }

    private static void validateCustomDelimiterForm(String delimiter) {
        if (delimiter.isEmpty() || Pattern.matches(InputValidationConstants.CONTAINS_NUMBERS_PATTERN, delimiter))
            throw new IllegalArgumentException(InputValidationConstants.INVALID_INPUT_EXCEPTION_MESSAGE);
    }

    private static void validateInputWithNormalDelimiter(String input) {
        if(input.isEmpty())
            return;

        String cleanedInput = input.replace(" ", "");
        if(!Pattern.matches(InputValidationConstants.NORMAL_DELIMITER_INPUT_PATTERN, cleanedInput)) {
            throw new IllegalArgumentException(InputValidationConstants.INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
