package calculator.service;

import java.util.List;

public class AdditionService implements CalculatorService {

    @Override
    public Integer calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
