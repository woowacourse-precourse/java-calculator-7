package calculator;

public class ExtractService {
    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\\n";
    public static final String EMPTY = "";
    public static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();

    public String extractCustomDelimiter(String readInput) {
        if (hasCustomDelimiter(readInput)) {
            int[] positions = findCustomDelimiterPosition(readInput);
            return extractDelimiter(readInput, positions);
        }
        return EMPTY;
    }

    public String extractPositiveString(String readInput, String customDelimiter) {
        if (hasCustomDelimiter(readInput)) {
            String remove = createRemoveString(customDelimiter);
            return readInput.replace(remove, EMPTY);
        }
        return readInput;
    }

    private boolean hasCustomDelimiter(String readInput) {
        return readInput.contains(CUSTOM_PREFIX) && readInput.contains(CUSTOM_SUFFIX);
    }

    private int[] findCustomDelimiterPosition(String readInput) {
        int prefixPos = readInput.indexOf(CUSTOM_PREFIX) + CUSTOM_PREFIX_LENGTH; // "//" 문자열 크기 만큼 이후 탐색을 위해 합산
        int suffixPos = readInput.indexOf(CUSTOM_SUFFIX);
        return new int[] {prefixPos, suffixPos};
    }

    private String extractDelimiter(String readInput, int[] position) {
        return readInput.substring(position[0], position[1]);
    }

    private String createRemoveString(String customDelimiter) {
        return CUSTOM_PREFIX + customDelimiter + CUSTOM_SUFFIX;
    }
}
