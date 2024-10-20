package calculator.calculator;

import calculator.io.InputString;


public class Calculator {
    private InputString inputString;

    public Calculator() {
        this.inputString = new InputString();
    }

    public void playCalculator() {
        String input = inputString.input();
    }
}