package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.ConsoleView;
import java.util.List;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ConsoleView consoleView;

    public CalculatorController(CalculatorService calculatorService, ConsoleView consoleView) {
        this.calculatorService = calculatorService;
        this.consoleView = consoleView;
    }

    public void run() {
        String input = consoleView.getInput();
        List<String> numbers = calculatorService.splitByDelimiters(input);
        consoleView.displayResult(calculatorService.sum(numbers));
    }
}
