package calculator.domain.calculator;

import calculator.domain.input.InputParser;

public class StringAddCalculator {

    private static final int DEFAULT_SUM_RESULT = 0;

    private final InputParser inputParser;
    private final Calculator calculator;

    public StringAddCalculator(final InputParser inputParser, final Calculator calculator) {
        this.inputParser = inputParser;
        this.calculator = calculator;
    }

    public int splitAndSum(final String input) {
        if (nullOrEmptyString(input)) {
            return DEFAULT_SUM_RESULT;
        }

        final Integer[] extractNumbers = inputParser.extractNumbersFromInput(input);

        return calculator.sumAll(extractNumbers);
    }

    private boolean nullOrEmptyString(final String input) {
        return input == null || input.isEmpty();
    }
}
