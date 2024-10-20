package calculator.service;

import java.util.List;

import calculator.model.Calculator;
import calculator.model.StringSeparator;

public class CalculatorService {

    private final Calculator calculator = new Calculator();
    private final StringSeparator separator = new StringSeparator();

    public Integer calculateNumberTotal(String input) {
        List<Integer> numbers = separator.extractNumbers(input);
        return calculator.calculateTotal(numbers);
    }
}
