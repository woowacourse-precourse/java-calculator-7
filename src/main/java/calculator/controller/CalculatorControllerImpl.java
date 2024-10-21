package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class CalculatorControllerImpl implements CalculatorController{
    private final StringCalculator stringCalculator;
    private final CalculatorView calculatorView;

    public CalculatorControllerImpl(StringCalculator stringCalculator, CalculatorView calculatorView) {
        this.stringCalculator = stringCalculator;
        this.calculatorView = calculatorView;
    }

    @Override
    public void run() {
        String input = calculatorView.getInput();
        int result = stringCalculator.add(input);
        calculatorView.printResult(result);
    }
}
