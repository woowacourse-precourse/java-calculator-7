package calculator.util;

public class ExtractUtil {
    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\\n";
    public static final String EMPTY = "";
    public static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();

    public String extractCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            int[] positions = findCustomDelimiterPosition(input);
            return extractDelimiter(input, positions);
        }
        return EMPTY;
    }

    private boolean hasCustomDelimiter(String input) {
        return input.contains(CUSTOM_PREFIX) && input.contains(CUSTOM_SUFFIX);
    }

    private int[] findCustomDelimiterPosition(String input) {
        int prefixPos = input.indexOf(CUSTOM_PREFIX) + CUSTOM_PREFIX_LENGTH; // "//" 문자열 크기 만큼 이후 탐색을 위해 합산
        int suffixPos = input.indexOf(CUSTOM_SUFFIX);
        return new int[] {prefixPos, suffixPos};
    }

    private String extractDelimiter(String input, int[] position) {
        return input.substring(position[0], position[1]);
    }

    public String extractPositiveString(String input, String customDelimiter) {
        String remove = createRemoveString(customDelimiter);
        return input.replace(remove, EMPTY);
    }

    private String createRemoveString(String customDelimiter) {
        return CUSTOM_PREFIX + customDelimiter + CUSTOM_SUFFIX;
    }
}
