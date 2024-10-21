package calculator;

import java.util.regex.Pattern;

public class DelimiterParser {
    // 기본 구분자
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static String parse(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.contains("\\n") ? input.indexOf("\\n") : input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid delimiter: " + input);
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            return Pattern.quote(customDelimiter);
        }
        return DEFAULT_DELIMITERS;
    }

    public static String extractNumbers(String input) {
        if (input.startsWith("//")) {
            int numbersStartIndex = input.contains("\\n") ? input.indexOf("\\n") + 2 : input.indexOf("\n") + 1;
            return input.substring(numbersStartIndex);
        }
        return input;
    }
}
