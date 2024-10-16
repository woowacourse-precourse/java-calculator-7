package calculator.service;

import calculator.domain.model.Calculator;
import calculator.domain.model.ExtractedInput;
import calculator.service.util.DelimiterExtractor;
import calculator.service.util.InputParser;

public class CalculatorService {
    public int calculateSum(String input) {
        ExtractedInput extractedInput = DelimiterExtractor.extractDelimiters(input);
        Calculator calculator = Calculator.of(InputParser.parseByDelimiters(extractedInput));
        return calculator.calculateSum();
    }
}
