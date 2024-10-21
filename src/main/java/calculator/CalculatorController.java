package calculator;

import calculator.common.io.InputProcessor;
import calculator.common.io.OutputHandler;

public class CalculatorController {

    private final InputProcessor inputProcessor;
    private final OutputHandler outputHandler;
    private final CalculatorService calculatorService;

    public CalculatorController(InputProcessor inputProcessor, OutputHandler outputHandler, CalculatorService calculatorService) {
        this.inputProcessor = inputProcessor;
        this.outputHandler = outputHandler;
        this.calculatorService = calculatorService;
    }

    public void sum() {
        String input = inputProcessor.getUserInput();
        if (input.isEmpty()) {
            outputHandler.printSumResult(0);
            return;
        }
        int result = calculatorService.sum(input);
        outputHandler.printSumResult(result);
    }
}
