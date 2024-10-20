package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    CalculatorService calculatorService = new CalculatorService();

    public void start() {
        String input= CalculatorView.InputString();
        calculatorService.mainController(input);
    }
}
