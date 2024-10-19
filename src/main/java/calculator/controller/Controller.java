package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    private final Calculator calculator = new Calculator();

    public void run() {
        String input = InputView.readInputString();

        long result = calculator.calculate(input);

        OutputView.showOutput(result);
    }
}
