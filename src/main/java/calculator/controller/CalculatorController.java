package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;

public class CalculatorController {
    InputString inputString = new InputString();
    InputView inputView = new InputView();

    public void executeCalculator() {
        saveInputString();
    }

    private void saveInputString() {
        inputString.setUserInput(inputView.enterInputString());
    }
}
