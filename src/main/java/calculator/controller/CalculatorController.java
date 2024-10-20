package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculatorService = new CalculatorService();
    }

    public void input() {
        String s = inputView.inputString();
        inputView.close();
        int addedResult = calculatorService.add(s);
        output(addedResult);
    }

    private void output(int i) {
        outputView.outputInteger(i);
    }

}
