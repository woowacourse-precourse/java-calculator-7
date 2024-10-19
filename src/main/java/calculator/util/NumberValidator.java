package calculator.util;

public class NumberValidator {

    private static final String NO_DIGIT_MESSAGE = "문자가 아닌, 숫자로만 더하기 계산을 할 수 있어요.";
    private static final String NO_NEGATIVE_MESSAGE = "음수가 아닌, 양수로만 계산을 진행할 수 있어요.";
    private static final int ZERO = 0;

    public void validateNoDigits(char[] chars) {
        for (char ch : chars) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException(NO_DIGIT_MESSAGE);
        }
    }

    public void validateNoNegatives(int[] numbers) {
        for (int number : numbers) {
            if (isNegative(number))
                throw new IllegalArgumentException(NO_NEGATIVE_MESSAGE);
        }
    }

    private boolean isNegative(int number) {
        return number < ZERO;
    }
}
