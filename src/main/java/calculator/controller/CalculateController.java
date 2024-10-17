package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {

    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorService service;

    public CalculateController(OutputView outputView, InputView inputView, CalculatorService calculatorService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.service = calculatorService;
    }

    public void start() {
        outputView.printStartMessage();
        Integer result = service.getResult(inputView.getString());
        outputView.printResultMessage(result);
    }
}
