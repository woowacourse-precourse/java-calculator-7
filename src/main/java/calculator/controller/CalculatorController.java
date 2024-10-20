package calculator.controller;

import calculator.domain.Numbers;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    private CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public static CalculatorController newInstance() {
        return new CalculatorController(new CalculatorService());
    }

    public void run() {
        String userInput = CalculatorView.getUserInput();
        Numbers numbers = calculatorService.extractNumbers(userInput);
    }
}
