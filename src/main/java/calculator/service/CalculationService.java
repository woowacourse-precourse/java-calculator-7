package calculator.service;

import calculator.domain.InputHandler;
import calculator.domain.Calculator;
import calculator.domain.SimpleCalculator;

import java.util.List;

public class CalculationService {
    private final Calculator calculator = new SimpleCalculator();

    public Number calculate(String input) {
        InputHandler inputHandler = new InputHandler(input);
        List<Double> numbers = inputHandler.getParsedNumbers();
        return calculator.calculateSum(numbers);
    }
}
