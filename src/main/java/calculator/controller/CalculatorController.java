package calculator.controller;

import calculator.view.InputHandler;
import calculator.view.OutputHandler;
import calculator.model.StringCalculator;

public class CalculatorController {

    private final StringCalculator calculator;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public CalculatorController(StringCalculator calculator, InputHandler inputHandler, OutputHandler outputHandler) {
        this.calculator = calculator;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        String input = inputHandler.getInput();
        int result = calculator.add(input);
        outputHandler.printResult(result);
    }
}
