package calculator.model;

import java.util.List;

public class Calculator {
    public int calculateResult(List<Integer> extractedNumbers) {
        return extractedNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
