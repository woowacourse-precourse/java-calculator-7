package calculator.controller;

import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void execute() {
        calculatorService.printPrompt();
        String rawInput = calculatorService.input();
        String[] paredInput = calculatorService.parsingInput(rawInput);
        String[] nums = calculatorService.validateInput(paredInput);
        int result = calculatorService.sum(nums);
    }
}
