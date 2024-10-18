package calculator.domain;

import java.util.List;

public class AddingMachine {
    private final List<Integer> numbers;

    public AddingMachine(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long addNumbers() {
        return numbers.stream().mapToLong(Integer::longValue).sum();
    }
}
