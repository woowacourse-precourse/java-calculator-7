package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputForSum = inputView.readInputForSum();

        Calculator calculator = new Calculator();

        outputView.printResult(calculator.calculate(inputForSum));
    }
}
