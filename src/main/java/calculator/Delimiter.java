package calculator;

public class Delimiter {
    public static final int DELIMITER_START_INDEX = 2;
    public static final int CUSTOM_DELIMITER_PREFIX_SIZE = 2;
    public static final int CUSTOM_DELIMITER_SUFFIX_SIZE = 2;
    public static final String DEFAULT_DELIMITER = "[,:]";
    private final String delimiter;
    private boolean isCustomDelimiter;
    private final int size;

    public Delimiter(String inputString) {
        isCustomDelimiter = false;
        delimiter = validateCustomDelimiter(inputString);
        size = delimiter.length();
    }

    private String validateCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            for (int i = DELIMITER_START_INDEX; i < input.length(); i++) {
                if (input.startsWith("\\n", i)) {
                    isCustomDelimiter = true;
                    return input.substring(DELIMITER_START_INDEX, i);
                }
            }
        }
        return DEFAULT_DELIMITER;
    }

    public String get() {
        return delimiter;
    }

    public boolean isCustomDelimiter() {
        return isCustomDelimiter;
    }

    public int size() {
        return size;
    }
}
