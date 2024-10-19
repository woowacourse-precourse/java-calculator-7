package calculator;

import java.util.List;

public class Adder {
    private List<Integer> numbers;

    public Adder(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumNumbers() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
