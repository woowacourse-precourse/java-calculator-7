package calculator.validator;

import calculator.constant.CalculatorConstants;
import calculator.constant.ExceptionMessageConstants;

public class InputValidator {
    public void validate(String input) {
        if (input.startsWith(CalculatorConstants.CUSTOM_DELIMITER_PREFIX)) {
            validateCustomSeparator(input);
        }
    }

    private void validateCustomSeparator(String input) {
        int newLineIndex = input.indexOf(CalculatorConstants.CUSTOM_DELIMITER_SUFFIX);
        if (newLineIndex == -1 || newLineIndex <= CalculatorConstants.CUSTOM_DELIMITER_PREFIX.length()) {
            throw new IllegalArgumentException(ExceptionMessageConstants.INVALID_CUSTOM_DELIMITER);
        }

        String customSeparator = input.substring(CalculatorConstants.CUSTOM_DELIMITER_PREFIX.length(), newLineIndex);

        if (customSeparator.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessageConstants.INVALID_CUSTOM_DELIMITER);
        }

        String restOfInput = input.substring(newLineIndex + CalculatorConstants.CUSTOM_DELIMITER_SUFFIX.length());
        
        if (restOfInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessageConstants.MISSING_NUMBER_AFTER_DELIMITER);
        }
    }
}