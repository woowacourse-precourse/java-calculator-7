package calculator;

import java.util.List;

public class PositiveNumbers {
    private static final PositiveNumbers EMPTY_INSTANCE = new PositiveNumbers(List.of());

    private final List<Integer> numbers;

    private PositiveNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static PositiveNumbers from(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return EMPTY_INSTANCE;
        }
        return new PositiveNumbers(numbers);
    }

    public int calculateSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}