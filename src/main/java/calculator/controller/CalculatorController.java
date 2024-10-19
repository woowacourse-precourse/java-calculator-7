package calculator.controller;

import calculator.model.Numbers;
import calculator.model.UserInput;
import calculator.service.Calculate;
import calculator.service.StringParser;
import calculator.service.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;
    private final Calculate calculate;
    private final Validator validator;

    public CalculatorController(InputView inputView, OutputView outputView, StringParser stringParser,
                                Calculate calculate, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringParser = stringParser;
        this.calculate = calculate;
        this.validator = validator;
    }

    public void run() {
        UserInput userInput = new UserInput(inputView.readUserInput());
        validator.validateInput(userInput);
        Numbers numbers = stringParser.parse(userInput);
        outputView.calculateOutput(calculate.addition(numbers));
    }
}
