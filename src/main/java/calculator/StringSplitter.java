package calculator;

public class StringSplitter {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private static StringSplitter instance;

    private StringSplitter() {
    }

    public static StringSplitter getInstance() {
        if (instance == null) {
            instance = new StringSplitter();
        }
        return instance;
    }
}