package calculator.controller;

import calculator.view.StartView;

public class CalculatorController {
    public static void runCalculator() {
        StartView.printStartView();
        String input = StartView.getInputView();
    }
}
