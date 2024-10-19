package calculator.controller;

import calculator.model.Calculator;
import calculator.view.ConsoleInputView;
import calculator.view.ConsoleOutputView;

public class CalculatorController {
    private final Calculator calculator;
    private final ConsoleInputView input;
    private final ConsoleOutputView output;

    public CalculatorController(ConsoleInputView input, Calculator calculator,  ConsoleOutputView output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    public void run() {
        String userInput = input.getInput();
        int result = calculator.add(userInput);
        output.showResult(result);
    }
}
