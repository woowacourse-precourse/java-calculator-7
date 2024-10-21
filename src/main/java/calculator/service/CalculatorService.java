package calculator.service;

import calculator.dto.CalculatorRequest;
import calculator.dto.CalculatorResponse;
import calculator.model.Calculator;
import java.util.List;

public class CalculatorService {
    public CalculatorResponse calculateSum(CalculatorRequest request) {
        List<Integer> numbers = NumberParser.parseByDelimiters(request);
        Calculator calculator = Calculator.of(numbers);
        return new CalculatorResponse(calculator.sum());
    }
}
