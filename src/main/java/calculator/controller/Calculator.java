package calculator.controller;

import calculator.model.StringSumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final StringSumCalculator stringSumCalculator;

    public Calculator() {
        this.stringSumCalculator = new StringSumCalculator();
    }

    public void run() {
        String inputString = InputView.inputString();

        double result = stringSumCalculator.calculate(inputString);

        OutputView.printResult(result);
    }
}
