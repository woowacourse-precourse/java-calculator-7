package calculator.controller;

import calculator.model.Calculator;
import calculator.model.vo.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStart();
        String expression = inputView.inputNumbers();

        Calculator calculator = new Calculator();
        Number sum = calculator.calculate(expression);

        outputView.printResult(sum);
    }
}
