package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputManager;
import calculator.model.delimiter.Delimiters;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void startCalculate() {
        String input = inputView.readNumber();

        Delimiters delimiters = new Delimiters(input);
        InputManager inputManager = new InputManager(input, delimiters);
        Calculator calculator = new Calculator(inputManager);

        outputView.printResult(calculator.getResult());
    }
}
