package calculator.constant;


import java.util.regex.Pattern;

public class ValidConstants {
    public static final int MAX_TOTAL_LENGTH = 100;
    public static final int MAX_SEPARATOR_LENGTH = 5;
    public static final int MAX_NUMBER_COUNT = 100;

    public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("^//(.*)\\\\n(.*)");
    public static final String NUMBER_PATTERN = "^\\d{1,20}$";

}
