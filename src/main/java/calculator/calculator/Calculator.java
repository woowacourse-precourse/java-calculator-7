package calculator.calculator;

import calculator.input.InputString;


public class Calculator {
    private InputString inputString;

    public Calculator() {
        this.inputString = new InputString();
    }

    public void playCalculator() {
        String input = inputString.input();
    }
}
