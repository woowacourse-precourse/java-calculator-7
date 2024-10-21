package calculator.strategy;


public class DelimiterStrategyFactory {
    public static DelimiterStrategy getDelimiterStrategy(String input) {
        if (input.startsWith("//")) {
            return new CustomDelimiterStrategy(input);
        }
        return new DefaultDelimiterStrategy();
    }
}