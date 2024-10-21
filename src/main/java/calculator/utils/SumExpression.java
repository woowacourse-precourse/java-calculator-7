package calculator.utils;

import calculator.model.CalculatorValues;

public class SumExpression {

    public static int sum(CalculatorValues calculatorValues) {
        return calculatorValues.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }
}
