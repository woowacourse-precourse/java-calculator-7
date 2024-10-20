package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    CalculatorView calculatorView = new CalculatorView();
    CalculatorService calculatorService = new CalculatorService();

    public void calculateString() {

        String userInput = calculatorView.getUserInput();
        int result = calculatorService.calculateString(userInput);
        calculatorView.showResult(result);
    }
}
