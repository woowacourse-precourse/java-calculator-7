package calculator.controller;

import calculator.view.InputView;

public class CalculatorOperation {

    private String inputString;

    public void operateCalculator() {
        getUserInputByView();
    }

    private void getUserInputByView() {
        InputView inputView = new InputView();
        inputString = inputView.getUserInput();
    }
}
