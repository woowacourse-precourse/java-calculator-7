package calculator.model;

import java.util.List;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sumNumbers() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
