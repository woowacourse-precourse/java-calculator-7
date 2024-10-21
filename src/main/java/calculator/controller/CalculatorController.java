package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorService calculatorService, CalculatorView calculatorView) {
        this.calculatorService = calculatorService;
        this.calculatorView = calculatorView;
    }

    public void execute() {
        calculatorView.printPrompt();
        String rawInput = calculatorService.input();
        String[] paredInput = calculatorService.parsingInput(rawInput);
        String[] nums = calculatorService.validateInput(paredInput);
        int result = calculatorService.sum(nums);
        calculatorView.printResult(result);
    }
}
