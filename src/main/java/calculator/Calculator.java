package calculator;

import java.util.List;

public class Calculator {

    public static PositiveNumber sum(List<PositiveNumber> numbers) {
        int sum = numbers.stream()
                .mapToInt(PositiveNumber::getValue)
                .sum();
        return new PositiveNumber(sum);
    }
}
