package calculator.controller;

import calculator.controller.io.InputHandler;
import calculator.controller.io.OutputHandler;
import calculator.model.CalculatorModel;

public class CalculatorController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CalculatorModel calculatorModel;

    public CalculatorController(InputHandler inputHandler, OutputHandler outputHandler,
                                CalculatorModel calculatorModel) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.calculatorModel = calculatorModel;
    }

    public void run() {
        String userInput = inputHandler.getUserInput();
        int result = calculatorModel.calculate(userInput);
        outputHandler.displayResult(result);
    }

}
