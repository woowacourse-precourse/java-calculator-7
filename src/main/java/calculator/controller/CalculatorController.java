package calculator.controller;

import calculator.model.UserInput;
import calculator.view.InputView;

public class CalculatorController {
    private final UserInput userInput;

    public CalculatorController() {
        this.userInput = new UserInput();
    }

    public void run() {
        userInput.setUserInput(InputView.inputUserString());
    }
}
