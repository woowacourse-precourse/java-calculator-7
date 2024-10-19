package calculator.domain.delimiter;

import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_END;
import static calculator.view.enums.Message.INVALID_CUSTOM_DELIMITER_FORMAT;
import static calculator.view.enums.Message.INVALID_CUSTOM_DELIMITER_LENGTH;

public class CustomDelimiter {

    public void registerCustomDelimiter(String input, Delimiter delimiter) {
        if (!input.contains(CUSTOM_DELIMITER_END.getPattern())) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage(CUSTOM_DELIMITER_END.getPattern()));
        }

        int newLineIndex = input.indexOf(CUSTOM_DELIMITER_END.getPattern());

        String customDelimiterPart = input.substring(2, newLineIndex);

        if (customDelimiterPart.length() != 1 || Character.isDigit(customDelimiterPart.charAt(0))) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_LENGTH.getMessage());
        }

        char customDelimiter = customDelimiterPart.charAt(0);
        delimiter.addCustomDelimiter(customDelimiter);
    }

}
