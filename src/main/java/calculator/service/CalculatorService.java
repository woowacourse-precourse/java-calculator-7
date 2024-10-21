package calculator.service;

public class CalculatorService {
    private static final int ZERO = 0;
    private final StringParser stringParser = new StringParser();
    private final Calculator calculator = new Calculator();

    public int calculate(String input) {
        if (input.isEmpty()) {
            return ZERO;
        }

        String[] parsed = stringParser.parseString(input);
        return calculator.getSum(parsed);
    }
}
