package calculator.domain;

import java.util.Arrays;

public class Calculator {
    public int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
