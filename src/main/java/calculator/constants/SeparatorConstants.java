package calculator.constants;

public final class SeparatorConstants {
    private SeparatorConstants() {};

    public static final String DEFAULT_COMMA_SEPARATOR =  ",";
    public static final String DEFAULT_COLON_SEPARATOR =  ":" ;

    public static final String CUSTOM_SEPARATOR_PREFIX = "//";
    public static final String CUSTOM_SEPARATOR_SUFFIX = "\\n";

    // 커스텀 구분자 문자열의 길이
    public static final int CUSTOM_SEPARATOR_PREFIX_LENGTH = CUSTOM_SEPARATOR_PREFIX.length();
    public static final int CUSTOM_SEPARATOR_SUFFIX_LENGTH = CUSTOM_SEPARATOR_SUFFIX.length();

    public static final int MAX_CUSTOM_SEPARATOR_LENGTH =  1;
}
