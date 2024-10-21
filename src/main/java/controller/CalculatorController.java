package controller;

import model.StringCalculator;
import view.InputView;
import view.OutputView;

public class CalculatorController {
    public void run() {
        String input = InputView.getInput();
        int result = StringCalculator.add(input);
        OutputView.printResult(result);
    }
}
