package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.DigitParser;
import java.util.List;

public class CalculatorController {

    private final Calculator calculator;
    private final DigitParser digitParser;

    public CalculatorController(Calculator calculator, DigitParser digitParser) {
        this.calculator = calculator;
        this.digitParser = digitParser;
    }

    public Integer sumFromString(String input) {
        List<Integer> numbers = digitParser.parse(input);
        return calculator.sumOf(numbers);
    }
}
