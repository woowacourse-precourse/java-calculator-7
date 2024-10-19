package calculator.controller;

import calculator.model.Calculator;
import calculator.view.ConsoleView;

public class CalculatorController {
    private final Calculator calculator;
    private final ConsoleView view;

    public CalculatorController(Calculator calculator, ConsoleView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        String input = view.getInput();
        int result = calculator.add(input);
        view.displayResult(result);
        String userInput = input.getInput();
        int result = calculator.add(userInput);
    }
}
