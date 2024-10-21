package calculator.controller;

import calculator.domain.Number;
import calculator.service.CalculatorService;
import calculator.ui.InputManager;
import calculator.ui.OutputView;

public class CalculatorController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public CalculatorController(
            final InputManager inputManager,
            final OutputView outputView,
            final CalculatorService calculatorService
    ) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void start() {
        String input = inputManager.getAddValue();
        Number result = calculatorService.add(input);
        outputView.printResult(result);
    }
}
