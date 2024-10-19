package calculator;

import calculator.service.CalculatorService;
import java.util.List;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Integer executeCalculation(List<Integer> numbers) {
        return calculatorService.calculate(numbers);
    }
}
