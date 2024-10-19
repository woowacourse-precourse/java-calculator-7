package calculator.util;

public class ExtractUtil {
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final String EMPTY = "";
    private static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();

    public String extractCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            int[] positions = findCustomDelimiterPosition(input);
            return input.substring(positions[0], positions[1]);
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

    public String extractPositiveString(String input, String customDelimiter) {
        String removalLine = createRemoveString(customDelimiter);
        return input.replace(removalLine, EMPTY);
    }

    private String createRemoveString(String customDelimiter) {
        return CUSTOM_PREFIX + customDelimiter + CUSTOM_SUFFIX;
    }
}
