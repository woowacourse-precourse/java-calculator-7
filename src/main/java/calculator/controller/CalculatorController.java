package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ConsoleView consoleView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.consoleView = new ConsoleView();
    }

    public void run() {
        String input = consoleView.getInput();
        int result = calculatorService.calculator(input);
        consoleView.outputResult(result);
    }

}
