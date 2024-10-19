package calculator.regex.constant;

import java.util.regex.Pattern;

public class RegexConstant {
    public static final Pattern ONLY_NUMBER_SEPARATOR_REGEX = Pattern.compile("[1-9]\\d*([,:][1-9]\\d*)*");
    public static final Pattern ONLY_NUMBER_SEPARATOR_DOUBLE_REGEX = Pattern.compile("^(?:0\\.(?!0+([,:]|$))\\d+|[1-9]\\d*(?:\\.\\d+)?)(?:[,:](?:0\\.(?!0+([,:]|$))\\d+|[1-9]\\d*(?:\\.\\d+)?))*$");
    public static final Pattern CUSTOM_SEPARATOR_REGEX = Pattern.compile("^//([^\\d\\s])\\\\n[1-9]\\d*(\\1[1-9]\\d*)*$");
    public static final Pattern CUSTOM_SEPARATOR_DOUBLE_REGEX = Pattern.compile("^//([^\\d\\s.])\\\\n(0\\.(?!0+($|\\D))\\d+|[1-9]\\d*(\\.\\d+)?)(\\1(0\\.(?!0+($|\\D))\\d+|[1-9]\\d*(\\.\\d+)?))*$");
    public static final Pattern BLANK_REGEX = Pattern.compile("^$");
}
