package calculator.domain;

import java.util.List;

public class Operands {
    private final List<Number> operands;

    public Operands(List<String> values) {
        this.operands = values.stream()
                .map(Number::new)
                .toList();
    }

    public int sum() {
        int sum = 0;
        for (Number number : operands) {
            sum = number.addToSum(sum);
        }
        return sum;
    }
}
