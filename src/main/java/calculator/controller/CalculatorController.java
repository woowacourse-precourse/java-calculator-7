package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ConsoleInputView;
import calculator.view.ConsoleOutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final ConsoleInputView input;
    private final ConsoleOutputView output;

    public CalculatorController(ConsoleInputView input, CalculatorService calculatorService, ConsoleOutputView output) {
        this.input = input;
        this.calculatorService = calculatorService;
        this.output = output;
    }

    public void run() {
        String userInput = input.getInput();
        int result = calculatorService.add(userInput);
        output.showResult(result);
    }
}
