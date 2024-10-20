package calculator.controller;

import calculator.model.CalculationInput;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import java.util.ArrayList;

public class CalculatorController {

    CalculatorView calculatorView = new CalculatorView();
    CalculatorService calculatorService = new CalculatorService();

    public void calculateString() {

        String userInput = calculatorView.getUserInput();
        int result = calculatorService.calculateString(userInput);
        calculatorView.showResult(result);
    }
}
