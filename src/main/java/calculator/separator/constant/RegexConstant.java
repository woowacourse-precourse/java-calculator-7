package calculator.separator.constant;

import java.util.regex.Pattern;

public class RegexConstant {
    public static final int EXTRACT_START_WITH_ADD_INDEX = 2;
    public static final int EXTRACT_SLASH_NEXT_LINE_ADD_INDEX = 1;
    public static final String SINGLE_BACK_SLASH = "\\";
    public static final String DOUBLE_BACK_SLASH = "\\\\";
    public static final String FORWARD_SLASH = "/";
    public static final Pattern ONLY_NUMBER_SEPARATOR_REGEX = Pattern.compile("\\d+([,:]\\d+)*");
    public static final Pattern CUSTOM_SEPARATOR_REGEX = Pattern.compile("^//([^\\d\\s]+)\\\\n\\d+(\\1\\d+)*$");
    public static final Pattern BLANK_REGEX = Pattern.compile("^$");

}
