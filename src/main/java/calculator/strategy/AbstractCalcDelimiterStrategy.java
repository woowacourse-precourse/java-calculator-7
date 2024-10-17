package calculator.strategy;

import calculator.exception.NegativeNumberException;
import java.util.Arrays;

public abstract class AbstractCalcDelimiterStrategy implements CalculatorDelimiterStrategy {

    @Override
    public Integer execute(String input) {
        return Arrays.stream(splitNumbers(input))
                .reduce(0, Integer::sum);
    }

    protected Integer[] processNumbers(String numbers, String delimiter) {
        return Arrays.stream(numbers.split(delimiter))
                .map(this::parseNumber)
                .filter(this::isNonNegative)
                .toArray(Integer[]::new);
    }

    protected Integer parseNumber(String numberString) {
        if (numberString.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numberString);
    }


    protected boolean isNonNegative(Integer value) {
        if (value < 0) {
            throw new NegativeNumberException();
        }
        return true;
    }
}

