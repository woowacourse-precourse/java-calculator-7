package calculator.service.calculator.impl;

import calculator.number.domain.NumberService;
import calculator.service.calculator.CalculatorService;

public class DoubleCalculatorProcess implements CalculatorService{
    @Override
    public Number sum(NumberService number) {
        return number.getNumbers()
                .stream()
                .mapToDouble(Number::doubleValue)
                .reduce(0.0, Double::sum);
    }
}
