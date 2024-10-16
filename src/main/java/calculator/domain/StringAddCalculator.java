package calculator.domain;

public class StringAddCalculator {

    private final InputParser inputParser;
    private final Calculator calculator;

    private static final int DEFAULT_SUM_RESULT = 0;

    public StringAddCalculator(final InputParser inputParser, final Calculator calculator) {
        this.inputParser = inputParser;
        this.calculator = calculator;
    }

    public int splitAndSum(final String input) {
        if (input == null || input.isEmpty()) {
            return DEFAULT_SUM_RESULT;
        }

        final Integer[] inputValue = inputParser.splitIncludeCustomDelimiter(input);

        return calculator.sumAll(inputValue);
    }
}
