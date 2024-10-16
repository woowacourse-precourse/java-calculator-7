package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {

    public void callCalculator() {

    }

    public String startCalculate() {
        InputView.printInputMessage();
        return InputView.userInput();
    }
}
