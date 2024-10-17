package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void startCalculate() {
        OutputView.printCalculateStartMessage();
        String input = InputView.inputString();
    }
}
