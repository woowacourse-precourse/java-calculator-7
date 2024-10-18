package calculator.Constants;

public class DelimiterConstants {
    public final static String COMMA = ",";
    public final static String COLONS = ":";
    public final static String DOT = ".";
    public final static String BASIC_DELIMITER = COMMA + "|" + COLONS;
    public final static String CUSTOM_DELIMITER_START = "//";
    public final static String CUSTOM_DELIMITER_END = "\\n";
    public final static String CUSTOM_INDICATOR_REGEX = "//|\\\\n";
    public final static int CUSTOM_DELIMITER_START_INDEX = 2;
}
