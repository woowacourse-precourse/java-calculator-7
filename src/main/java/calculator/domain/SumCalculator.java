package calculator.domain;

import java.util.List;
import java.util.Optional;

public class SumCalculator implements Calculator {

    public int calculate(List<Integer> data) {
        Optional<Integer> reduceResult = data.stream().reduce(Integer::sum);
        return reduceResult.orElseGet(() -> 0);
    }
}
