package calculator.model;

import calculator.model.number.Number;
import calculator.model.number.NumberParser;

public class AdditionCalculator {
    private final NumberParser numberParser;

    public AdditionCalculator(String input) {
        this.numberParser = new NumberParser(input);
    }

    public int calculate() {
        int sum = 0;
        for (Number n : numberParser.getNumbers()) {
            sum += n.getNumber();
        }
        return sum;
    }
}
