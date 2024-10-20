package calculator.model;

public class StringCalculator {

    private final DelimiterParser delimiterParser;
    private final SumCalculator sumCalculator;

    public StringCalculator(DelimiterParser delimiterParser, SumCalculator sumCalculator) {
        this.delimiterParser = delimiterParser;
        this.sumCalculator = sumCalculator;
    }

    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = delimiterParser.parseNumbers(input);
        return sumCalculator.calculateSum(numbers);
    }
}
