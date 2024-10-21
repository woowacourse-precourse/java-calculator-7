package calculator.domain;

import java.util.Arrays;

public class Calculator {

    public int add(String[] numbers) {
        return Arrays.stream(numbers)
            .map(this::toPositiveInteger)
            .reduce(0, Integer::sum);
    }

    private int toPositiveInteger(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다: " + token);
        }
    }
}
