package calculator.model;

import java.util.List;

public class Calculate {
    private final List<Long> numbers;
    private long result = 0;

    public Calculate(List<Long> numbers) {
        this.numbers = numbers;
    }

    public Long sum() {
        if (numbers != null) {
            result = numbers.stream()
                    .mapToLong(Long::longValue)
                    .sum();
        }
        return result;

    }
}
