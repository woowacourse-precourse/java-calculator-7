package calculator.util;

public class SeparatorExtractor {
    public static String extractSeparators(String input) {
        String defaultSeparators = ",:";
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            String customSeparator = input.substring(2, newlineIndex);
            return defaultSeparators + customSeparator;
        }
        return defaultSeparators;
    }

    public static String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            return input.substring(input.indexOf("\\n") + 2);
        }
        return input;
    }
}
