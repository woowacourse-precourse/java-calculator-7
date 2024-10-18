package calculator.common;

public final class DelimiterConstant {

    private DelimiterConstant() {
    }

    public static final String DELIMITER_CREATOR_FRONT = "//";
    public static final String DELIMITER_CREATOR_BACK = "\\n";
    public static final int CUSTOM_DELIMITER_NOT_FOUND = -1;
    public static final String CUSTOM_EXTRACTOR_REGEX = "//(.*?)\\\\n";
    public static final int REQUIRED_MATCHER_GROUP_NUMBER = 1;
    public final static String DELIMITER_SEPERATOR = "|";
}
