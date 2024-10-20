package calculator;

import java.util.Arrays;

public class Calculator {
    private static final String BASE_REGEX = ",|:";
    public static final String OR_REGEX = "|";
    public static final String BACKSLASH_REGEX = "\\\\";

    public static int calculate(String s) {
        try {
            String regex = BASE_REGEX;
            String content = s;
            if (s.startsWith("//")) {
                regex += OR_REGEX + parseCustomSeparator(s);
                content = parseContent(s);
            }
            return Arrays.stream(content.split(regex))
                    .mapToInt(Integer::parseInt)
                    .peek(Calculator::validateNum)
                    .sum();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String parseCustomSeparator(String s) {
        String customSeparator = String.valueOf(s.charAt(2));
        if (customSeparator.matches(BACKSLASH_REGEX)) {
            customSeparator = BACKSLASH_REGEX;
        }
        return customSeparator;
    }

    private static String parseContent(String s) {
        return s.split("\\\\n")[1];
    }

    private static void validateNum(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
