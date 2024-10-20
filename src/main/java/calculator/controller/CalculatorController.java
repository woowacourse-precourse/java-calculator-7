package calculator.controller;

import calculator.model.DelimiterCalculator;
import calculator.model.InputProcessor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        String input = inputView.input();

        InputProcessor inputProcessor = new InputProcessor(input);
        DelimiterCalculator delimiterCalculator = new DelimiterCalculator(inputProcessor);

        int sum = delimiterCalculator.sum();

        outputView.printResult(sum);
    }
}
