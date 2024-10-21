package calculator.controllers;

import calculator.services.CalculatorService;
import calculator.views.CalculatorInputView;

public class CalculatorController {
    public void start() {
        CalculatorInputView.displayInputPrompt();

        String inputData = CalculatorInputView.readInput();

        String result = CalculatorService.sum(inputData);

        CalculatorInputView.displayResult(result);
    }
}
