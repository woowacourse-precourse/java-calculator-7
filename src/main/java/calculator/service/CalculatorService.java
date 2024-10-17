package calculator.service;

import calculator.model.Calculator;
import java.util.List;

public class CalculatorService {
    private final Calculator calculator;
    private final NumberExtractionService numberExtractionService;

    public CalculatorService(Calculator calculator, NumberExtractionService numberExtractionService) {
        this.calculator = calculator;
        this.numberExtractionService = numberExtractionService;
    }

    public int calculate() {
        List<Integer> numbers = numberExtractionService.getNumbers();
        return calculator.calculate(numbers);
    }
}
