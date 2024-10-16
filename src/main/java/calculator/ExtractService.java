package calculator;

public class ExtractService {

    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\\n";
    public static final String EMPTY = "";
    public static final int CUSTOM_PREFIX_LENGTH = CUSTOM_PREFIX.length();

    public String extractCustomDelimiter(String readInput) {
        if (readInput.contains(CUSTOM_PREFIX) && readInput.contains(CUSTOM_SUFFIX)) {
            int startPos = readInput.indexOf(CUSTOM_PREFIX);
            int endPos = readInput.indexOf(CUSTOM_SUFFIX);

            return readInput.substring(startPos + CUSTOM_PREFIX_LENGTH, endPos);
        }

        return EMPTY;
    }

    public String extractPositiveString(String readInput, String customDelimiter) {
        if (!customDelimiter.isBlank()) {
            String remove =  CUSTOM_PREFIX + customDelimiter + CUSTOM_SUFFIX;
            return readInput.replace(remove, EMPTY);
        }

        return readInput;
    }
}
