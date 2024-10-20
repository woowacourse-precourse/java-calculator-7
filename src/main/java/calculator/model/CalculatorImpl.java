package calculator.model;

import java.util.List;

public class CalculatorImpl implements Calculator {
    @Override
    public int sum(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
