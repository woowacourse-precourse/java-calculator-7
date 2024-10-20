package calculator.validator;

import calculator.enums.ErrorMessage;

public class CalculatorValidator {

    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private final int CUSTOM_DELIMITER_SUFFIX_INDEX = 3;

    public boolean validateCustomDelimiterInput(String inputString) {
        if (!startsWithCustomDelimiterPrefix(inputString)) {
            return false;
        }
        if (!isValidFormat(inputString)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_FORMAT_ERROR.getMessage());
        }
        return true;
    }

    private boolean startsWithCustomDelimiterPrefix(String inputString) {
        return inputString.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private boolean isValidFormat(String inputString) {
        return inputString.indexOf(CUSTOM_DELIMITER_SUFFIX) == CUSTOM_DELIMITER_SUFFIX_INDEX;
    }

    public void validateInputToken(String inputToken) {
        for (int i = 0; i < inputToken.length(); i++) {
            char part = inputToken.charAt(i);
            if (!Character.isDigit(part)) {
                throw new IllegalArgumentException(ErrorMessage.TOKEN_FORMAT_ERROR.getMessage(part));
            }
        }
    }
}

