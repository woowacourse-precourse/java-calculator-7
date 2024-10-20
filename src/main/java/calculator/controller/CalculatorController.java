package calculator.controller;

import calculator.model.UserString;
import calculator.view.InputView;
import java.math.BigInteger;

public class CalculatorController {

    private final InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public BigInteger process() {
        String userInput = inputView.input();

        if (userInput.isBlank()) {
            return new BigInteger("0");
        }

        UserString userString = new UserString(userInput);
        return userString.sum();
    }
}
