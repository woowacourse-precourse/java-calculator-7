package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorService {

    public String checkCustomSeparator(String inputData) {
        if (inputData.startsWith("//")) {
            if (!(inputData.indexOf('n') == -1)) {
                return Constants.DEFAULT_CUSTOM_SEPARATOR + validateCustomSeparator(inputData).replace("\\", "\\\\");
            }
        }
        return Constants.DEFAULT_CUSTOM_SEPARATOR;
    }

    private String validateCustomSeparator(String inputData) {
        String customSeparator = inputData.substring(2, inputData.indexOf('n'));

        validateSpecialCharacterRegex(customSeparator);
        return customSeparator;
    }

    private void validateSpecialCharacterRegex(String separator) {
        if (!Pattern.matches(Constants.SPECIAL_CHARACTER_REGEX, separator)) {
            throw new IllegalArgumentException(Constants.SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    public int additionCalculator(String userInputData, String customSeparator) {
        String trimInputData;
        if (userInputData.startsWith("//")) {
            trimInputData = userInputData.substring(userInputData.indexOf('n') + 1);
        } else {
            trimInputData = userInputData;
        }

        String calculatorRegex = "[" + customSeparator + "]";
        String calculatorStringRegex = "[0-9" + customSeparator + "]*[0-9]";

        if (!Pattern.matches("^" + calculatorStringRegex + "+$", trimInputData)) {
            throw new IllegalArgumentException(Constants.CUSTOM_SPECIAL_CHARACTER_ERROR_MESSAGE);
        }

        int[] numbers = Arrays.stream(trimInputData.split(calculatorRegex)).mapToInt(Integer::parseInt).toArray();

        int calcResult = 0;

        for (int number : numbers) {
            calcResult += number;
        }

        return calcResult;
    }
}

