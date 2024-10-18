package calculator.sumCalculator;

import calculator.common.io.InputHandler;
import calculator.common.io.OutputHandler;

public class CalculatorController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CalculatorService calculatorService;

    public CalculatorController(InputHandler inputHandler, OutputHandler outputHandler, CalculatorService calculatorService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.calculatorService = calculatorService;
    }

    public void sum() {
        String input = inputHandler.getUserInput();
        if (input.isEmpty()) {
            outputHandler.printSumResult(0);
            return;
        }
        int result = calculatorService.sum(input);
        outputHandler.printSumResult(result);
    }
}
