package calculator.validation;

import java.util.Arrays;

import static calculator.constants.DelimiterEnum.*;
import static calculator.controller.ExceptionMessage.MUST_BE_DIGIT;

public class InputValidator {
    public static boolean isCheckEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }

    public static void isContainZero(String userInput) {
        if (userInput.equals("0")) {
            throw new IllegalArgumentException(MUST_BE_DIGIT.format());
        }
    }

    public static void isContainMinus(String[] numbers) {
        if (Arrays.toString(numbers).contains(MINUS.getValue())) {
            throw new IllegalArgumentException(MUST_BE_DIGIT.format());
        }
    }
}
