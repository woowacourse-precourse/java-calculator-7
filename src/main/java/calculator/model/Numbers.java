package calculator.model;

import java.util.List;

public class Numbers {

    private List<Integer> numbers;
    private final int INITIAL_VALUE = 0;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sumNumbers() {
        return numbers.stream()
                .reduce(INITIAL_VALUE, Integer::sum);
    }
}
