package calculator.util;

import calculator.constants.InputValidationConstants;
import calculator.domain.UserInput;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validate(UserInput userInput){
        if(userInput.hasCustomDelimiter()){
            String delimiter = userInput.getDelimiters().getFirst();

            validateCustomDelimiterForm(delimiter);
            validateInputWithCustomDelimiter(userInput.getInput(), delimiter);
        }
        else
            validateInputWithNormalDelimiter(userInput.getInput());
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
        if(!Pattern.matches(InputValidationConstants.NORMAL_DELIMITER_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException(InputValidationConstants.INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
