package calculator.controller;

import calculator.model.Adder;
import calculator.util.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class PositiveNumStringCalculator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Validator validator = new Validator();
    private Adder adder = new Adder(validator);

    public void startCalculator() {
        String userInput = inputView.startUserInput();
        String[] validatedInput = validator.validateInput(userInput);
        String result = adder.addNums(validatedInput);
        outputView.printResult(result);
    }
}
