package calculator;

import calculator.enums.ErrorText;

public class InputValidator {
    public void validateCustomDelimiterFormat(int startIndex, int endIndex) {
        if(startIndex+2 != endIndex-1) {
            throw new IllegalArgumentException(ErrorText.CUSTOM_DELIMITER_FROMAT.getErrorText());
        }
    }

    public void validateCustomDelimiterPosition(int startIndex, int endIndex) {
        if(startIndex != 0 || endIndex != 3) {
            throw new IllegalArgumentException(ErrorText.CUSTOM_DELIMITER_POSITION.getErrorText());
        }
    }

    public void validateUnspecifiedCharacters(String splitResult) {
        try {
            if(Integer.parseInt(splitResult) < 0) {
                throw new IllegalArgumentException(ErrorText.POSITIVE_NUMBERS_ONLY.getErrorText());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorText.NUMBERS_AND_DELIMITERS_ONLY.getErrorText() + e);
        }
    }
}
