package calculator.validator;

import static calculator.util.StringCalculatorUtils.convertToIntArray;
import static calculator.util.StringCalculatorUtils.extractDelimiter;
import static calculator.util.StringCalculatorUtils.extractStringWithoutDelimiterFormat;
import static calculator.util.StringCalculatorUtils.findIndex;
import static calculator.util.StringCalculatorUtils.isCustom;
import static calculator.util.StringCalculatorUtils.parseBasic;
import static calculator.util.StringCalculatorUtils.parseCustom;

public class StringCalculatorValidator {

    public void check(String input) {
        if (isCustom(input)) {
            validateCustom(input);
        } else {
            validateBasic(input);
        }
    }

    private void validateCustom(String input) {
        validateCustomDelimiter(input);
        validateCustomNumber(input);
    }

    private void validateCustomDelimiter(String custom) {
        int[] indices = findIndex(custom);

        if (isCustomDelimiterBlank(indices)) {
            throw new IllegalArgumentException("Input custom delimiter.");
        }

        String delimiter = extractDelimiter(custom, indices);
        String extractedString = extractStringWithoutDelimiterFormat(custom, indices);
        if (!isValidCustomFormat(extractedString, delimiter)) {
            throw new IllegalArgumentException("Invalid custom delimiter detected.");
        }
    }

    private void validateCustomNumber(String custom) {
        int[] indices = findIndex(custom);
        String[] parsedNumbers = parseCustom(custom, indices);
        int[] numberArray = convertToIntArray(parsedNumbers);

        validatePositive(numberArray);
    }

    private void validateBasic(String input) {
        validateBasicDelimiter(input);
        validateBasicNumber(input);
    }

    private void validateBasicDelimiter(String basic) {
        if (!isValidBasicFormat(basic)) {
            throw new IllegalArgumentException("Invalid input detected.");
        }
    }

    private void validateBasicNumber(String basic) {
        int[] numberArray = convertToIntArray(parseBasic(basic));

        validatePositive(numberArray);
    }

    private void validatePositive(int[] numberArray) {
        for (int i : numberArray) {
            if (i < 0) {
                throw new IllegalArgumentException("Input positive numbers only.");
            }
        }
    }


    private boolean isCustomDelimiterBlank(int[] indices) {
        return indices[0] + 2 >= indices[1];
    }

    private boolean isValidCustomFormat(String custom, String delimiter) {
        for (int i = 0; i < custom.length(); i++) {
            char currentChar = custom.charAt(i);
            if (!Character.isDigit(currentChar) && currentChar != '-' && !(Character.toString(
                    currentChar).equals(delimiter))) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidBasicFormat(String basic) {
        for (int i = 0; i < basic.length(); i++) {
            if (!Character.isDigit(basic.charAt(i)) && basic.charAt(i) != ':'
                    && basic.charAt(i) != ','
                    && basic.charAt(i) != '-') {
                return false;
            }
        }

        return true;
    }

}
