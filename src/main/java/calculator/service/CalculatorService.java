package calculator.service;

import calculator.domain.model.Calculator;
import calculator.domain.model.ExtractedInput;
import calculator.dto.CalculationResultDTO;
import calculator.service.util.DelimiterExtractor;
import calculator.service.util.InputParser;

public class CalculatorService {
    public CalculationResultDTO calculateSum(String input) {
        ExtractedInput extractedInput = DelimiterExtractor.extractDelimiters(input);
        Calculator calculator = Calculator.of(InputParser.parseByDelimiters(extractedInput));
        return new CalculationResultDTO(calculator.calculateSum());
    }
}
