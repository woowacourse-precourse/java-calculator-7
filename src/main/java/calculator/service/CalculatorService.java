package calculator.service;

import calculator.dto.CalculatorRequest;
import calculator.model.Calculator;
import java.util.List;

public class CalculatorService {
    public void calculateSum(CalculatorRequest request) {
        List<Integer> numbers = NumberParser.parseByDelimiters(request);
        Calculator calculator = Calculator.of(numbers);
        int result = calculator.sum();
    }
}
