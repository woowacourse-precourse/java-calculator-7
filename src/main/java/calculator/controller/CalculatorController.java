package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            String input = inputView.readInput();
            int result = calculatorService.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
