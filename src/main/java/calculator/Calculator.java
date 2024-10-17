package calculator;

import calculator.service.CalculatorService;
import java.util.List;

public class Calculator {
    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Integer executeCalculation(List<Integer> numbers) {
        return calculatorService.calculate(numbers);
    }
}
