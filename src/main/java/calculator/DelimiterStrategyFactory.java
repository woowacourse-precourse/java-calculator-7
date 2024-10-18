package calculator;

public class DelimiterStrategyFactory {
    public static DelimiterStrategy getDelimiterStrategy(String input){
        if (input.startsWith("//")){
            return new CustomDelimiterStrategy();
        }
        return new DefaultDelimiterStrategy();
    }
}
