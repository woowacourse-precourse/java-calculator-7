package calculator.validator;

import calculator.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";

    public void validateInput(String input) {
        validateInputWithDelimiter(input);
        validateInputWithoutDelimiter(input);
    }

    private void validateInputWithDelimiter(String input) {
        if (input.startsWith(CUSTOM_START) && !input.contains(CUSTOM_END)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INVALID_INPUT;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    private void validateInputWithoutDelimiter(String input) {
        String NUMBER_REGEXP = "^[\\d].*";
        if (!input.startsWith(CUSTOM_START) && !Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INVALID_INPUT;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
