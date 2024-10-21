package calculator.controller;

import calculator.domain.Calculator;
import calculator.util.InputParser;
import calculator.view.CalculatorView;

public class CalculatorController {
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void runCalculator() {
        String input = calculatorView.inputNumber();
        InputParser inputParser = new InputParser();
        Calculator calculator = new Calculator(input, inputParser);
        int result = calculator.add(input);
        CalculatorView.printResult(result);
    }
}
