package calculator.controller;

import calculator.service.CalculationService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculationService calculationProcessor;

    public CalculationController(InputView inputView, OutputView outputView, CalculationService calculationProcessor) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculationProcessor = calculationProcessor;
    }

    public void run() {
        outputView.displayInputPrompt();
        String input = inputView.getInput();
        int calculatedResult = calculationProcessor.process(input);
        outputView.displayResult(calculatedResult);
    }
}
