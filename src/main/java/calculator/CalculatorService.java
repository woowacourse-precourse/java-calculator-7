package calculator;

import java.util.regex.Pattern;

public class CalculatorService {

    public String checkCustomSeparator(String inputData) {
        if (inputData.startsWith("//")) {
            if (inputData.charAt(3) == 'n') {
                return Constants.DEFAULT_CUSTOM_SEPARATOR + "|" + validateCustomSeparator(inputData);
            }
        }
        return Constants.DEFAULT_CUSTOM_SEPARATOR;
    }

    private String validateCustomSeparator(String inputData) {
        String customSeparator = inputData.substring(2, 3);
        validateSpecialCharacterRegex(customSeparator);
        return customSeparator;
    }

    private void validateSpecialCharacterRegex(String separator) {
        if (!Pattern.matches(Constants.SPECIAL_CHARACTER_REGEX, separator)) {
            throw new IllegalArgumentException(Constants.SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }
}

