package calculator.service;

import java.util.Arrays;

public class Calculator {

    public int add(int[] numbers) {
        return Arrays.stream(numbers).map(this::validatePositive).sum();
    }

    private int validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] Calculator: 음수는 계산할 수 없습니다.");
        }
        return number;
    }
}
