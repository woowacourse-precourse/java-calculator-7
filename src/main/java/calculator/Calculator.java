package calculator;

import java.util.List;

public class Calculator {
    public Calculator() {
    }

    public int getSummary(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
