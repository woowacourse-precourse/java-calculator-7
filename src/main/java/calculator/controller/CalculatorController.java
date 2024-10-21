package calculator.controller;

import calculator.model.calculator.Calculator;

public class CalculatorController {
    private static CalculatorController instance = new CalculatorController();

    private CalculatorController() {
    }

    public static CalculatorController getInstance() {
        return instance;
    }

    Calculator calculator = Calculator.getInstance();

    public Long calculate(String userInput) {
        return calculator.calculate(userInput);
    }
}
