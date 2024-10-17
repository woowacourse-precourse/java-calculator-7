package calculator;

public class ExtractService {

    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\\n";
    public static final String EMPTY = "";
    public static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();

    public String extractCustomDelimiter(String readInput) {
        if (hasCustomDelimiter(readInput)) {
            int[] position = findCustomDelimiterPosition(readInput);
            return extractDelimiter(readInput, position);
        }
        return EMPTY;
    }

    private String extractDelimiter(String readInput, int[] position) {
        return readInput.substring(position[0] + CUSTOM_PREFIX_LENGTH, position[1]);
    }

    private int[] findCustomDelimiterPosition(String readInput) {
        int startPos = readInput.indexOf(CUSTOM_PREFIX);
        int endPos = readInput.indexOf(CUSTOM_SUFFIX);

        return new int[] {startPos, endPos};
    }

    private boolean hasCustomDelimiter(String readInput) {
        return readInput.contains(CUSTOM_PREFIX) && readInput.contains(CUSTOM_SUFFIX);
    }

    public String extractPositiveString(String readInput, String customDelimiter) {
        if (!customDelimiter.isBlank()) {
            String remove =  CUSTOM_PREFIX + customDelimiter + CUSTOM_SUFFIX;
            return readInput.replace(remove, EMPTY);
        }

        return readInput;
    }
}
