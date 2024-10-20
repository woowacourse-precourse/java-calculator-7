package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;

import java.util.List;

public class CalculatorController {
    InputString inputString = new InputString();
    InputView inputView = new InputView();
    StringValidator stringValidator = new StringValidator();

    public void executeCalculator() {
        saveInputString();
    }

    private void saveInputString() {
        inputString.setUserInput(inputView.enterInputString());
        List<Integer> userOperand = stringValidator.convertStringToIntegerList(inputString.getUserInput());
        inputString.setUserOperand(userOperand);
    }
}
