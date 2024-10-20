package calculator;

public class Constants {
    public static String SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR_PREFIX = "//";
    public static final String CUSTOM_SEPARATOR_SUFFIX = "\\n";
    public static final String REGEX_CUSTOM_SEPARATOR_PATTERN = "//(.*?)\\\\n";
    public static final String REGEX_INPUT_PATTERN =
            "(^[0-9]+([,:][0-9]+)*|^((//.\\\\n)*[0-9]+(.[0-9]+)*))";
}
