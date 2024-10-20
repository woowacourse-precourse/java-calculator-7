package calculator.controller;

import calculator.domain.Numbers;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorView calculatorView;
    private final CalculatorService calculatorService;

    private CalculatorController(CalculatorView calculatorView, CalculatorService calculatorService) {
        this.calculatorView = calculatorView;
        this.calculatorService = calculatorService;
    }

    public static CalculatorController newInstance() {
        return new CalculatorController(
                new CalculatorView(),
                new CalculatorService());
    }

    public void run() {
        String userInput = calculatorView.getUserInput();
        Numbers numbers = calculatorService.extractNumbers(userInput);
        calculatorView.showResult(numbers);
    }
}
