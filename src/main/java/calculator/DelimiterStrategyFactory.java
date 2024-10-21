package calculator;

public class DelimiterStrategyFactory {
    public static DelimiterStrategy create(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            return new CustomDelimiterStrategy(customDelimiter);
        }
        return new CommaColonStrategy();
    }

    public static String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf('\n');
        return input.substring(2, input.indexOf('\n'));
    }
}
