package calculator.delimiter;

public class CustomDelimiterDetector implements CustomDelimiterDetectorInterface {
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\n";

    @Override
    public String findCustomDelimiter(String input) {
        int prefixIndex = input.indexOf(DELIMITER_PREFIX);
        int suffixIndex = input.indexOf(DELIMITER_SUFFIX);
        if (prefixIndex < suffixIndex && prefixIndex != -1) {
            return input.substring(prefixIndex + DELIMITER_PREFIX.length(), suffixIndex);
        }
        return "";
    }

    @Override
    public String removeCustomDelimiter(String text, String delimiter){
        return text.replace(DELIMITER_PREFIX + delimiter + DELIMITER_SUFFIX, "");
    }
}
