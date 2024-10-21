package controller;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(Calculator calculator, InputView inputView, OutputView outputView) {
        this.calculator = calculator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void processUserInput() {
        try {
            String userInput = inputView.readInput();
            int sum = calculator.processInputAndSum(userInput);
            outputView.printResult(sum);
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            throw error;
        }
    }
}
