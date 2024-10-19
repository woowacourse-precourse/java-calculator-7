package calculator.controller;

import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    InputString inputString = new InputString();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    StringValidator stringValidator = new StringValidator();
    Integer result = 0;

    public void executeCalculator() {
        saveInputString();
        calculate();
        sendResultMessage();
    }

    private void saveInputString() {
        inputString.setUserInput(inputView.enterInputString());
        List<Integer> userOperand = stringValidator.validate(inputString.getUserInput());
        inputString.setUserOperand(userOperand);
    }

    private void calculate() {
        result = inputString.getUserOperand().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void sendResultMessage() {
        outputView.printResult(result);
    }

}
