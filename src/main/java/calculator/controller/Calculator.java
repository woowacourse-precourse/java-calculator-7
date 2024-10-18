package calculator.controller;

import calculator.model.NumberAdder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final NumberAdder numberAdder;

    public Calculator() {
        this.numberAdder = start();
    }

    private NumberAdder start() {
        return new NumberAdder(InputView.inputString());
    }

    public void add() {
        try {
            OutputView.printResult(numberAdder.calculate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
