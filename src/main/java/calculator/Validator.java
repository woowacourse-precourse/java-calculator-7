package calculator;

import static calculator.Constant.BOTH_ENDS_OF_THE_STRING_MUST_BE_A_NUMBER;
import static calculator.Constant.INVALID_VALUE_IN_NUMBER_EXTRACTION;
import static calculator.Constant.SEPARATORS_CANNOT_COME_IN_SUCCESSION;

import java.util.Arrays;

public class Validator {

    public static String makeCorrectInput(String input) {
        if (input.isBlank()) {
            input = "0";
        }

        return input.trim();
    }

    public static String validateConvertedInput(String input, String delimiterRegex, String[] strNumArray) {
        if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException(BOTH_ENDS_OF_THE_STRING_MUST_BE_A_NUMBER);
        }
        String continuousRegex = ".*(" + delimiterRegex + "){2,}.*";
        if (input.matches(continuousRegex)) {
            throw new IllegalArgumentException(SEPARATORS_CANNOT_COME_IN_SUCCESSION);
        }

        boolean splitIsNotValid = Arrays.stream(strNumArray)
                .anyMatch(s -> !s.matches("\\d+"));
        if (splitIsNotValid) {
            throw new IllegalArgumentException(INVALID_VALUE_IN_NUMBER_EXTRACTION);
        }

        return input;
    }
}
