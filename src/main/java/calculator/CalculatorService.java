package calculator;

import java.util.regex.Pattern;

public class CalculatorService {

    Calculator calculator = new Calculator();

    public void checkCustomSeparator(String inputData) {
        if (inputData.startsWith("//")) {
            if (inputData.charAt(3) == 'n') {
                validateCustomSeparator(inputData);
            }
        }
    }

    private void validateCustomSeparator(String inputData) {
        String customSeparator = inputData.substring(2, 3);
        validateSpecialCharacterRegex(customSeparator);
    }

    private void validateSpecialCharacterRegex(String separator) {
        if (!Pattern.matches(Constants.SPECIAL_CHARACTER_REGEX, separator)) {
            throw new IllegalArgumentException(Constants.SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }
}
