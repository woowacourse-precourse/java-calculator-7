package calculator.util;

public class RegexGenerator {
    private static final String DEFAULT_PREFIX = "[";
    private static final String DEFAULT_SUFFIX = "]";

    public static String generateRegex(String regex) {
        return DEFAULT_PREFIX + regex + DEFAULT_SUFFIX;
    }

    private RegexGenerator() {
    }
}