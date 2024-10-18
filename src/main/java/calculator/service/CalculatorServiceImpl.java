package calculator.service;

import calculator.domain.model.Calculator;
import calculator.dto.response.CalculatorResponse;
import calculator.dto.request.CalculatorRequest;

public class CalculatorServiceImpl implements CalculatorService {
    public CalculatorResponse calculateSum(CalculatorRequest request) {
        Calculator calculator = Calculator.of(InputParser.parseByDelimiters(request));
        return new CalculatorResponse(calculator.calculateSum());
    }
}
