package calculator.util;

public class NumberValidator {

    public static final int ZERO = 0;

    public void validateNoDigits(char[] chars) {
        for (char ch : chars) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException();
        }
    }

    public void validatorNoNegatives(int[] numbers) {
        for (int number : numbers) {
            if (isNegative(number))
                throw new IllegalArgumentException();
        }
    }

    private boolean isNegative(int number) {
        return number < ZERO;
    }
}
