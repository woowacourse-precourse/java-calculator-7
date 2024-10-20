package calculator.global.constant;

public class DelimiterConstant {

    public static final String PREFIX = "//";
    public static final String SUFFIX = "\\n";
    public static final String ESCAPE_REQUIRED_REGEX = "([\\\\^$*+?.(){}|\\[\\]])";
    public static final String ESCAPE_REPLACE_CHAR = "\\\\$1";
    public static final String VALID_NUMBER_REGEX = "^[0-9]*$";
    public static final int DELIMITER_LIMIT_LENGTH = 5;
}
