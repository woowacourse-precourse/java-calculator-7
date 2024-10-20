package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private Parser parser;

    public CalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        String input = inputView.getInput();
        parser = new Parser(input);
        int sum = calculator.add(parser.parse());
        outputView.printSum(sum);
    }
}
