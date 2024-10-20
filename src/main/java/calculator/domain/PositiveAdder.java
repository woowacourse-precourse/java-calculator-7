package calculator.domain;

import java.util.List;

public class PositiveAdder implements Adder{

    public int calculateSum(List<Number> sumTargets) {
        for (Number number : sumTargets) {
            if (number.getValue() < 0) {
                throw new IllegalArgumentException("양수만 계산할 수 있습니다: " + number.getValue());
            }
        }

        return sumTargets.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
