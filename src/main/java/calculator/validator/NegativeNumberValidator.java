package calculator.validator;

public class NegativeNumberValidator {
    public static void checkNegativeNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
        }
    }
}
