package calculator.domain;

import java.util.List;
import java.util.Optional;

public class Calculator {
    private int result;
    private final List<Integer> parsedNumbers;

    public Calculator(List<Integer> parsedNumbers) {
        this.parsedNumbers = parsedNumbers;
    }

    public int sum() {
        Optional<Integer> reduceResult = this.parsedNumbers.stream().reduce(Integer::sum);
        return reduceResult.orElseGet(() -> 0);
    }
}
