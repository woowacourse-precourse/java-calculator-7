package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {
    private final StringCalculator calculator;
    private final InputView inputView;
    private final ResultView resultView;

    public CalculatorController(StringCalculator calculator, InputView inputView, ResultView resultView) {
        this.calculator = calculator;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        String input = inputView.getInput();
        int result = calculator.calculate(input);
        resultView.printResult(result);
    }
}
