package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        outputView.printStartMessage();
        String input = inputView.readInput();

        int result = calculatorService.processCalculator(input);

        outputView.printResultMessage(result);
    }
}
