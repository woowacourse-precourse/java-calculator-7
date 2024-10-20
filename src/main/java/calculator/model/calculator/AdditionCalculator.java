package calculator.model.calculator;

import calculator.model.number.Number;
import calculator.model.number.NumberParser;

public class AdditionCalculator {
    private final NumberParser numberParser;
    private final int result;

    public AdditionCalculator(final String input) {
        this.numberParser = new NumberParser(input);
        this.result = calculate();
    }

    private int calculate() {
        int sum = 0;
        for (Number n : numberParser.getNumbers()) {
            sum += n.getNumber();
        }
        return sum;
    }

    public int getResult() {
        return result;
    }
}
