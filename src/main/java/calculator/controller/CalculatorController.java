package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String input = inputView.getInput();
        Calculator calculator = new Calculator();
        int calculated = calculator.calculate(input);
        outputView.print(calculated);
    }
}
