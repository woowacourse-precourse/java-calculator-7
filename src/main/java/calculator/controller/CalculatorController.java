package calculator.controller;

import calculator.Service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;

    public CalculatorController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    CalculatorService calculatorService = new CalculatorService();


    public void calculate() {
        outputView.printPrompt();
    }

}
