package calculator.service;

import java.util.List;
import java.util.Optional;

public class CalculatorService {
    public Optional<Integer> sum(List<Integer> integers) {
        return integers.stream()
                .reduce(Integer::sum);
    }
}
