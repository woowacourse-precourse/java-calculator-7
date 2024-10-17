package calculator.controller;

import calculator.service.CalculatorService;

import static calculator.view.InputView.getInput;
import static calculator.view.ResultView.printResult;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void calculatorStart() {
        String input = getInput();
        int result = calculatorService.calculateSum(input);
        printResult(result);

    }


}
