package calculator.controller;

import calculator.service.CalculationService;
import calculator.view.CalculationView;

public class CalculationController {

    private final CalculationService calculationService;
    private final CalculationView calculationView;

    public CalculationController() {
        this.calculationService = new CalculationService();
        this.calculationView = new CalculationView();
    }

    public void run() {
        String input = calculationView.getInput();
        int result = calculationService.calculate(input);
        calculationView.displayResult(result);

    }
}