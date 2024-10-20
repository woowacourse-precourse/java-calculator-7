package calculator.calculator;

import static calculator.exception.ErrorMessage.INVALID_NUMBER;
import static calculator.exception.ErrorMessage.NEGATIVE_NUMBER;
import static calculator.exception.ErrorMessage.OUT_OF_RANGE;

import calculator.exception.ExceptionHandler;
import calculator.validator.Validator;

public class StringCalculator implements Calculator {
    private final Validator validator;

    public StringCalculator() {
        this.validator = new Validator();
    }

    @Override
    public int add(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = toPositiveInteger(token);
            sum = safeAdd(sum, number);
        }
        return sum;
    }

    public int toPositiveInteger(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                ExceptionHandler.throwIllegalArgException(NEGATIVE_NUMBER, value);
            }
            return number;
        } catch (NumberFormatException e) {
            ExceptionHandler.throwIllegalArgException(INVALID_NUMBER, value);
            return 0; // This line will never be reached but is required to satisfy the compiler
        }
    }


    private static int safeAdd(int a, int b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            ExceptionHandler.throwIllegalArgException(OUT_OF_RANGE);
            return 0; // 도달하지 않음
        }
    }
}
