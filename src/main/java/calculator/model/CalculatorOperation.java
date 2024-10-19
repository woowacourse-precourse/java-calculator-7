package calculator.model;

import java.util.List;

public class CalculatorOperation { //추후 확장도 가능하도록 연산 기능은 분리

    public int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
