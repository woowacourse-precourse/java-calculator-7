package calculator.service;

import calculator.data.InputString;

public class StringPlusCalculator {

    private Calculation calculation = new Calculation();

    public Integer plusCalculate(InputString inputString) {

        return calculation.addOperands(inputString);
    }
}
