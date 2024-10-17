package calculator.view;

public class InputHandler {
    public static final String DELIMITER_PREFIX = "//";
    public static final String DELIMITER_SUFFIX = "\\n";

    private String delimiter = "[,:]";

    public int isCustomDelimiter(String input) {
        int length = DELIMITER_PREFIX.length();
        if (input.startsWith(DELIMITER_PREFIX) && input.indexOf(DELIMITER_SUFFIX) == length + 1) {
            delimiter = String.valueOf(input.charAt(length));
            return length + DELIMITER_SUFFIX.length() + 1;
        }
        return 0;
    }
}
