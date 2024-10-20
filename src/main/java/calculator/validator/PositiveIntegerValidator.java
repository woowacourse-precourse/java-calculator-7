package calculator.validator;


import calculator.global.exception.CalculatorException;
import calculator.global.message.ErrorMessage;
import java.util.List;

public class PositiveIntegerValidator {

    private PositiveIntegerValidator() {
    }

    public static void validatePositiveIntegers(List<String> numberStrings) {
        for (String numberString : numberStrings) {
            validatePositiveInteger(numberString);
        }
    }

    private static void validatePositiveInteger(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            if (number < 0) {
                throw CalculatorException.from(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
            }
        } catch (NumberFormatException e) {
            throw CalculatorException.from(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}