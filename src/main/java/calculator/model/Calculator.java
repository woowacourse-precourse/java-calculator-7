package calculator.model;

import java.util.Arrays;

public class Calculator {

    public int sum(String[] numberArr) {
        return Arrays.stream(numberArr)
                .mapToInt(this::parseNumber)
                .sum();
    }

    public int parseNumber(String number) {
        int num = Integer.parseInt(number);
        validateNumber(num);
        return num;
    }

    private void validateNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 불가능합니다.");
        }
    }
}
