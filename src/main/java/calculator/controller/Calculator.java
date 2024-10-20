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
        try {
            return new AdditionCalculator(InputView.inputString());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw new IllegalArgumentException("프로그램을 종료합니다.");
        }
    }

    public void add() {
        OutputView.printResult(additionCalculator.getResult());
    }
}
