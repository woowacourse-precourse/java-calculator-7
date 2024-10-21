package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, ResultView resultView, Calculator calculator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.calculator = calculator;
    }

    public void run() {
        String input = inputView.getInput();
        int result = calculator.add(input);
        resultView.displayResult(result);
    }
}