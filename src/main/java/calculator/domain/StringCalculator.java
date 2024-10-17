package calculator.domain;

import java.util.List;

public class StringCalculator {

    private final static int INITIAL_NUMBER = 0;
    private final static String EXCEPTION_MINUS_NUMBER = "음수는 입력 불가합니다.";
    private final static String EXCEPTION_STRING_NUMBER = "올바른 숫자 형식이 아닙니다.";

    private final List<String> numbers;

    public StringCalculator(List<String> numbers) {
        this.numbers = numbers;
    }

    public int calculateStrings() {
        int sum = INITIAL_NUMBER;
        try {
            for (String number : numbers) {
                int realNumber = Integer.parseInt(number);
                validateMinusNumber(realNumber);
                sum += realNumber;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_STRING_NUMBER);
        }
        return sum;
    }

    private void validateMinusNumber(int number) {
        if (number < INITIAL_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MINUS_NUMBER);
        }
    }
}
