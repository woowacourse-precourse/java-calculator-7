package calculator.controller;

import calculator.model.UserString;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public int process() {
        String userInput = inputView.input();

        if (userInput.equals("0")) {
            return 0;
        }
        UserString userString = new UserString(userInput);
        return userString.sum();
    }
}
