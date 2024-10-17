package calculator.service;

import calculator.model.Calculator;
import java.util.List;

public class CalculatorService {
    private final Calculator calculator;
    private final NumberExtractorService numberExtractorService;

    public CalculatorService(Calculator calculator, NumberExtractorService numberExtractorService) {
        this.calculator = calculator;
        this.numberExtractorService = numberExtractorService;
    }

    public int calculate() {
        List<Integer> numbers = numberExtractorService.getNumbers();
        return calculator.calculate(numbers);
    }
}
