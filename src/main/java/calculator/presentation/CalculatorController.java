package calculator.presentation;

import calculator.common.io.Input;
import calculator.common.io.Output;
import calculator.service.CalculatorService;

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

        if (isEmpty(userInput)) {
            output.printResult(0);
            return;
        }

        int result = calculatorService.calculate(userInput);
        output.printResult(result);

    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
