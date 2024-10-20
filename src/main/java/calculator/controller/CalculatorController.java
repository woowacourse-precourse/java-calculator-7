package calculator.controller;

import calculator.controller.io.InputHandler;
import calculator.controller.io.OutputHandler;
import calculator.model.CalculatorModel;
import calculator.model.InputParser;

public class CalculatorController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CalculatorModel calculatorModel;
    private final InputParser inputParser;

    public CalculatorController(InputHandler inputHandler, OutputHandler outputHandler,
                                CalculatorModel calculatorModel, InputParser inputParser) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.calculatorModel = calculatorModel;
        this.inputParser = inputParser;
    }

    public void run() {
        String userInput = inputHandler.getUserInput();
        int[] operands = inputParser.extractOperands(userInput);
        int result = calculatorModel.calculate(operands);
        outputHandler.displayResult(result);
    }

}
