package calculator.service;

import calculator.model.Calculator;
import java.util.List;

public class CalculatorService {
    private final Calculator calculator;
    private final NumberService numberService;

    public CalculatorService(Calculator calculator, NumberService numberService) {
        this.calculator = calculator;
        this.numberService = numberService;
    }

    public int calculate() {
        List<Integer> numbers = numberService.getNumbers();
        return calculator.calculate(numbers);
    }
}
