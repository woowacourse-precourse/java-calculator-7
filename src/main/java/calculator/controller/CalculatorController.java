package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.UserInput;
import calculator.view.InputView;

public class CalculatorController {
    private final Delimiter delimiter;
    private final UserInput userInput;

    public CalculatorController() {
        this.delimiter = new Delimiter();
        this.userInput = new UserInput();
    }

    public void run() {
        userInput.setUserInput(InputView.inputUserString());
    }
}
