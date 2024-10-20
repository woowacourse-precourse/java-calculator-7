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
            return null;
        }
    }

    public void add() {
        try {
            validateAdditionCalculator();
            OutputView.printResult(additionCalculator.getResult());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void validateAdditionCalculator() {
        if (additionCalculator == null) {
            throw new IllegalArgumentException("오류가 발생하여 애플리케이션을 종료합니다.");
        }
    }
}
