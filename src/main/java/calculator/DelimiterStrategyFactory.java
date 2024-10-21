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
        int newLineIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                newLineIndex = i;
                break;
            }
        }
        return input.substring(2, newLineIndex);
    }
}
