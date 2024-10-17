package calculator.domain;

import java.util.List;

public class Addition {

    private final List<Integer> numbers;

    public Addition(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int addNumber() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
