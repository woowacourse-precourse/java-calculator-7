package calculator.controller;

import calculator.model.calculator.AdditionCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final AdditionCalculator additionCalculator;

    public Calculator() {
        this.additionCalculator = start();
    }

    private AdditionCalculator start() {
        return new AdditionCalculator(InputView.inputString());
    }

    public void add() {
        OutputView.printResult(additionCalculator.getResult());
    }
}
