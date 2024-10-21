package calculator.utils;

import calculator.model.CalculatorValues;

import java.math.BigDecimal;

public class SumExpression {

    public static BigDecimal sum(CalculatorValues calculatorValues) {
        return calculatorValues.getNumbers()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
