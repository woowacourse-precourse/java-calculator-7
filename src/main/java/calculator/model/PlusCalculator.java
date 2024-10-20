package calculator.model;

import java.util.List;

public class PlusCalculator extends Calculator {

    private final Operator operator;

    public PlusCalculator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public int calculate(List<Integer> numbers) {
        return operator.operate(numbers);
    }
}

