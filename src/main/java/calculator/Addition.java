package calculator;

import java.util.Set;

public class Addition {

    private final Set<Integer> numbers;

    public Addition(Set<Integer> numbers) {
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
