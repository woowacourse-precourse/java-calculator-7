package calculator.calculator;

import java.util.List;
import java.util.function.BiFunction;

public class Calculator {
    private final BiFunction<Integer, Integer, Integer> calculateFunction;

    public Calculator(BiFunction<Integer, Integer, Integer> calculate) {
        this.calculateFunction = calculate;
    }

    public Integer calculate(List<Integer> operands, Integer initialValue) {
        return operands.stream()
                .reduce(calculateFunction::apply).orElse(initialValue);
    }
}
