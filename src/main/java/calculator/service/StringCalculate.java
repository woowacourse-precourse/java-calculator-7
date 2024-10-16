package calculator.service;

import calculator.model.Calculator;

public class StringCalculate {

    Calculator calculator = Calculator.getInstance();

    public void calculate() {
        calculator.saveResult();
    }

    public int fetchResult() {
        return calculator.getResult();
    }
}
