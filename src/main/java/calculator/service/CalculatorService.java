package calculator.service;

import calculator.dto.InputRequest;
import calculator.dto.OutputResponse;
import calculator.model.PlusCalculator;
import calculator.model.PlusOperator;
import calculator.parser.CalculatorParser;

import java.util.List;

public class CalculatorService {

    private final PlusCalculator plusCalculator;

    public CalculatorService() {
        this.plusCalculator = new PlusCalculator(new PlusOperator());
    }

    public OutputResponse calculate(InputRequest request) {
        List<Integer> numbers = CalculatorParser.parseForDelimiters(request);
        return OutputResponse.of(plusCalculator.calculate(numbers));
    }
}
