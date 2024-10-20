package calculator.service;

import calculator.model.Extractor;
import calculator.model.Calculator;
import java.util.List;

public class CalculatorService {

    public long calculate(String input) {
        Extractor extractor = new Extractor(input);
        List<Long> numbers = extractor.extractNumbers(input);
        Calculator calculator = new Calculator(numbers);
        return calculator.sum();
    }
}
