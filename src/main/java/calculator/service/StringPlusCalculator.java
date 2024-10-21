package calculator.service;

import calculator.data.InputString;

public class StringPlusCalculator {

    private static StringPlusCalculator singleInstance;
    private final Calculation calculation;

    private StringPlusCalculator() {
        calculation = Calculation.makeDefaultCalculation();
    }

    public static StringPlusCalculator getInstance() {
        if (singleInstance == null) {
            singleInstance = new StringPlusCalculator();
        }
        return singleInstance;
    }

    public Integer plusCalculate(InputString inputString) {

        return calculation.addOperands(inputString);
    }
}
