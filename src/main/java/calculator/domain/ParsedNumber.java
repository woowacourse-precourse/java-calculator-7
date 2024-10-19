package calculator.domain;

import java.util.List;

public class ParsedNumber {
    private final List<Integer> numbers;

    public ParsedNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
