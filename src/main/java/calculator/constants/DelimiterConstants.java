package calculator.constants;

public class DelimiterConstants {
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    public static final int CUSTOM_DELIMITER_BOUND_LENGTH = 4;

    private DelimiterConstants() {
        throw new RuntimeException("Constants class cannot be instantiated");
    }

}
