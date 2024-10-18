package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();
    private final CalculatorView calculatorView = new CalculatorView();

    public int processInput(String input) {
        int result = calculatorService.calculate(input);
        calculatorView.displayOutput(result);
        return result;
    }
}
