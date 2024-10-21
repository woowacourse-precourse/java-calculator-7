package calculator.domain;

import calculator.global.DelimiterUtils;

public class DelimiterStrategyFactory {
    public static DelimiterStrategy create(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            return new CustomDelimiterStrategy(customDelimiter);
        }
        return new CommaColonStrategy();
    }

    public static String extractCustomDelimiter(String input) {
        int newLineIndex = DelimiterUtils.findNewlineIndex(input);
        return input.substring(2, newLineIndex);
    }
}
