package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class InputController {
    private final CalculatorService calculatorService = new CalculatorService();

    public void run(String input) {
        try {
            int result = calculatorService.calculate(input);
            ConsoleView.printResult(result);
        } catch (IllegalArgumentException e) {
            ConsoleView.printError(e.getMessage());
        }
    }
}
