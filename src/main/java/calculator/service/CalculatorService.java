package calculator.service;

import java.util.List;

import calculator.model.Calculator;
import calculator.model.StringSeparator;

public class CalculatorService {

    private final Calculator calculator = new Calculator();
    private final StringSeparator separator = new StringSeparator();

    public Integer calculateNumberTotal(String input) {
        List<Integer> numbers = separator.extractNumbers(input);
        try {
            return calculator.calculateTotal(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("계산 과정에서 오류가 발생하였습니다.");
        }
    }
}
