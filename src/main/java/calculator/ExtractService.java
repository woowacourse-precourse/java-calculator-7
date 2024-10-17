package calculator;

public class ExtractService {

    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\\n";
    public static final String EMPTY = "";
    public static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();

    public String getCustomDelimiter(String readInput) {
        if (hasCustomDelimiter(readInput)) {
            int[] position = findCustomDelimiterPosition(readInput);
            return extractDelimiter(readInput, position);
        }
        return EMPTY;
    }

    public String extractPositiveString(String readInput, String customDelimiter) {
        if (hasCustomDelimiter(readInput)) {
            String remove = buildRemoveString(customDelimiter);
            return removeCustomDelimiter(readInput, remove);
        }
        return readInput;
    }

    private boolean hasCustomDelimiter(String readInput) {
        return readInput.contains(CUSTOM_PREFIX) && readInput.contains(CUSTOM_SUFFIX);
    }

    private int[] findCustomDelimiterPosition(String readInput) {
        int startPos = readInput.indexOf(CUSTOM_PREFIX);
        int endPos = readInput.indexOf(CUSTOM_SUFFIX);

        return new int[] {startPos, endPos};
    }

    private String extractDelimiter(String readInput, int[] position) {
        return readInput.substring(position[0] + CUSTOM_PREFIX_LENGTH, position[1]);
    }

    private String buildRemoveString(String customDelimiter) {
        return CUSTOM_PREFIX + customDelimiter + CUSTOM_SUFFIX;
    }

    private String removeCustomDelimiter(String readInput, String remove) {
        return readInput.replace(remove, EMPTY);
    }
}
