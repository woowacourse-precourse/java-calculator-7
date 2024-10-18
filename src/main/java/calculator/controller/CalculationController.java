package calculator.controller;

import calculator.service.CalculationService;
import calculator.service.TokenizationService;
import calculator.view.CalculationView;
public class CalculationController {

    private final CalculationService calculationService;
    private final TokenizationService tokenizationService;
    private final CalculationView calculationView;

    public CalculationController(CalculationService calculationService, TokenizationService tokenizationService,
                                 CalculationView calculationView) {
        this.calculationService = calculationService;
        this.tokenizationService = tokenizationService;
        this.calculationView = calculationView;
    }

    public void calculate() {

        String input = calculationView.getInput();

        long[] arr = tokenizationService.tokenize(input);

        long result = calculationService.sum(arr);

        calculationView.displayResult(result);
    }
}
