package calculator;


public class Calculator {
    private final DelimiterParser delimiterParser = new DelimiterParser();

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return delimiterParser.parseInputToIntList(input).stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
