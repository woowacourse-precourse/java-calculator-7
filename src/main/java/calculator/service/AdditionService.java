package calculator.service;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdditionService implements CalculatorService {

    @Override
    public Integer calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
