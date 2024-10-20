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
        return numberParser.getNumbers().stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    public int getResult() {
        return result;
    }
}
