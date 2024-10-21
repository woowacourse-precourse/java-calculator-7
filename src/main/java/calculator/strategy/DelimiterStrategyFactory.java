package calculator.strategy;


public class DelimiterStrategyFactory {
    public static DelimiterStrategy getDelimiterStrategy(String input) {
        if (input.startsWith("//")) { // 커스텀 구분자를 포함한다면,
            return new CustomDelimiterStrategy(input);
        } // 커스텀 구분자를 포함하지 않는다면,
        return new DefaultDelimiterStrategy();
    }
}