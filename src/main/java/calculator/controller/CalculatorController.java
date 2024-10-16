package calculator.controller;

import calculator.model.UserInput;
import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        UserInput userInput = new UserInput(inputView.readUserInput());
    }
}
