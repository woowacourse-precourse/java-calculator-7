package calculator;

public class CalculatorUtils {
    public static final String BASIC_SEPARATOR = "([,:])";
    public static final String PREFIX_CUSTOM_SEPARATOR = "//";
    public static final String SUFFIX_CUSTOM_SEPARATOR = "\\n";


    public static String integerToString(Integer value) {
        return String.valueOf(value);
    }

    public static String[] split(String value, String separator) {
        return value.split(separator);
    }
}
