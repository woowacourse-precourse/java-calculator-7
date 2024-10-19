package calculator.controller;

import calculator.StringAdditionCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;
    private final StringAdditionCalculator calculator;

    public CalculatorController(OutputView outputView, InputView inputView, StringAdditionCalculator calculator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.calculator = calculator;
    }

    public void run() {
        outputView.askForStringToCalculate();
        String input = inputView.inputStringToCalculate();
        Long result = calculator.calculate(input);
        outputView.printResult(result);
    }
}
