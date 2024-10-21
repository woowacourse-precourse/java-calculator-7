package calculator.service;

import calculator.dto.InputRequest;
import calculator.dto.OutputResponse;
import calculator.model.Calculator;
import calculator.parser.FactorParser;
import java.util.List;

public class CalculatorService {

    public OutputResponse calculate(InputRequest inputRequest) {
        if (inputRequest.factors().length == 1 && inputRequest.factors()[0].isEmpty()) {
            return OutputResponse.of(0);
        }
        List<Integer> numbers = FactorParser.parseFactors(inputRequest.factors());
        int result = Calculator.operate(numbers);
        return OutputResponse.of(result);
    }
}
