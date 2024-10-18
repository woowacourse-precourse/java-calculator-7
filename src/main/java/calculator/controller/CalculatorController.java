package calculator.controller;

import calculator.model.MultiDelimiter;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final MultiDelimiter splitDelimiter = new MultiDelimiter();

    public void run() {
        String userInput = inputView.receiveUserInput();
        String[] operand = splitDelimiter.splitWithDelimiter(userInput);
    }
}
