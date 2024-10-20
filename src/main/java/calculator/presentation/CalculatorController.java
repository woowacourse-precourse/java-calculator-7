package calculator.presentation;

import calculator.common.io.Input;
import calculator.common.io.Output;
import calculator.application.CalculatorService;

public class CalculatorController {

    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.input = new Input();
        this.output = new Output();
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        String userInput = input.getInput();

        int result = calculatorService.calculate(userInput);
        output.printResult(result);
    }
}
