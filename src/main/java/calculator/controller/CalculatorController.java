package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        OutputView.printStartMessage();
        String inputStringForAddition = InputView.readInputString();
    }
}
