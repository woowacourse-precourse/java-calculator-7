package calculator.controller;

import calculator.model.Numbers;
import calculator.model.UserInput;
import calculator.service.Calculate;
import calculator.service.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;
    private final Calculate calculate;

    public CalculatorController(InputView inputView, OutputView outputView, StringParser stringParser,
                                Calculate calculate) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringParser = stringParser;
        this.calculate = calculate;
    }

    public void run() {
        UserInput userInput = new UserInput(inputView.readUserInput());
        Numbers numbers = stringParser.parse(userInput);
        outputView.calculateOutput(calculate.addition(numbers));
    }
}
