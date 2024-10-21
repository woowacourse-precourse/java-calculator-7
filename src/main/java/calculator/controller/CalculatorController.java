package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
public class CalculatorController {
    public void run() {
        String input = InputView.getInput();
        OutputView.printResult(0);
    }
}
