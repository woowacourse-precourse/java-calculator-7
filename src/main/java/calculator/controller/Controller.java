package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    public static void run() {
        OutputView.showOutput(Calculator.calculate(InputView.getString()));
    }
}
