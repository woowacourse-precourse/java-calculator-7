package calculator;

public class StringAddCalculator {
    private final DelimiterParser delimiterParser;
    private final TokenSumCalculator tokenSumCalculator;

    public StringAddCalculator() {
        this.delimiterParser = new DelimiterParser();
        this.tokenSumCalculator = new TokenSumCalculator();
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = delimiterParser.split(input);
        return tokenSumCalculator.sumTokens(tokens);
    }
}