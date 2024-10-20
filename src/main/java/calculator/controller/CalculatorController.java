package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.calculatorView = new CalculatorView();
    }

    public void run() {
        String input = calculatorView.readCalculatorInput();
        int result = calculatorService.sum(input);
        calculatorView.printCalculatorResult(result);
    }
}
