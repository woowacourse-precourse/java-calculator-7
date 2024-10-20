package calculator;

import java.util.List;

public class Calculator {
    public int sum(List<Integer> numbers) {
        int sum = 0;

        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다: " + number);
            }
            sum += number;
        }
        return sum;
    }
}
