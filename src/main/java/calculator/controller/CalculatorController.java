package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;

import java.util.List;

public class CalculatorController {
    InputString inputString = new InputString();
    InputView inputView = new InputView();
    StringValidator stringValidator = new StringValidator();
    Integer result = 0;

    public void executeCalculator() {
        saveInputString();
        calculate();
    }

    private void saveInputString() {
        inputString.setUserInput(inputView.enterInputString());
        List<Integer> userOperand = stringValidator.convertStringToIntegerList(inputString.getUserInput());
        inputString.setUserOperand(userOperand);
    }

    private void calculate() {
        result = inputString.getUserOperand().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
