package calculator.cal;

import calculator.cal.numberadder.NumberAdder;

public class CalculatorImpl implements Calculator {

    private final NumberAdder numberAdder;

    public CalculatorImpl(NumberAdder numberAdder) {
        this.numberAdder = numberAdder;
    }

    @Override
    public int add(String inputString) {
        int result = numberAdder.addProcess(inputString);
        return result;
    }
}
