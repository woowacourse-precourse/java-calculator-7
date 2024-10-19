package calculator;

public class ParsingStrategyFactory {
    public static ParsingStrategy getStrategy(String input) {
        if (input.startsWith("//")) {
            return new CustomParsingStrategy();
        } else {
            return new DefaultParsingStrategy();
        }
    }
}
