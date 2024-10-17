package calculator.controller;

import calculator.model.Numbers;
import calculator.model.UserInput;
import calculator.service.StringParser;
import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;
    private final StringParser stringParser;

    public CalculatorController(InputView inputView, StringParser stringParser) {
        this.inputView = inputView;
        this.stringParser = stringParser;
    }

    public void run() {
        UserInput userInput = new UserInput(inputView.readUserInput());
        Numbers numbers = stringParser.parse(userInput);
    }
}
