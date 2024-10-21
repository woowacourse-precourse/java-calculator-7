package calculator.domain.delimiter;

import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_END;
import static calculator.view.enums.Message.INVALID_CUSTOM_DELIMITER_FORMAT;
import static calculator.view.enums.Message.INVALID_CUSTOM_DELIMITER_LENGTH;

public class CustomDelimiterRegistrar {

    private static final int CUSTOM_DELIMITER_END_INDEX = 2;

    public void registerCustomDelimiter(String input, Delimiter delimiter) {
        validateDelimiterFormat(input);
        String customDelimiterPart = extractCustomDelimiterPart(input);
        validateCustomDelimiter(customDelimiterPart);
        delimiter.addCustomDelimiter(customDelimiterPart.charAt(0));
    }

    private void validateDelimiterFormat(String input) {
        if (!input.contains(CUSTOM_DELIMITER_END.getPattern())) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage(CUSTOM_DELIMITER_END.getPattern()));
        }
    }

    private String extractCustomDelimiterPart(String input) {
        int newLineIndex = input.indexOf(CUSTOM_DELIMITER_END.getPattern());
        return input.substring(CUSTOM_DELIMITER_END_INDEX, newLineIndex);
    }

    private void validateCustomDelimiter(String customDelimiterPart) {
        if (isInvalidCustomDelimiter(customDelimiterPart)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_LENGTH.getMessage());
        }
    }

    private boolean isInvalidCustomDelimiter(String customDelimiterPart) {
        return customDelimiterPart.length() != 1 || Character.isDigit(customDelimiterPart.charAt(0));
    }
}
