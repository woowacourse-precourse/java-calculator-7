package calculator.service;

import java.util.List;

public class Calculator {
    public int calculate(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}