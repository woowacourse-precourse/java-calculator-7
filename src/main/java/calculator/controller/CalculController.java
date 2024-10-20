package calculator.controller;

import calculator.service.CalculationService;
import static calculator.view.Input.getUserInput;
import static calculator.view.Output.displayResult;
import static calculator.view.Output.startCalculate;

public class CalculController {
    private final CalculationService calculationService = new CalculationService();

    public void start() {
        startCalculate();
        String input = getUserInput();
        Number result = calculationService.calculate(input);
        displayResult(result);
    }
}
