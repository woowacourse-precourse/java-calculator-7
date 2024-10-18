package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        String rawInput = inputView.getCalculatorInput();
        String result = calculatorService.calculate(rawInput);
    }
}
