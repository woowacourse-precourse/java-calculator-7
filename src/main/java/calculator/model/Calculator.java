package calculator.model;

import java.util.List;

public class Calculator {
    public int add(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
