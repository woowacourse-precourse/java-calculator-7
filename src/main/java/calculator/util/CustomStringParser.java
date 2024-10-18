package calculator.util;


import java.util.Arrays;

public class CustomStringParser{

    public static final char[] STANDARD_SEPARATOR = {',', ':'};

    public static final String CUSTOM_SEPARATOR_SUFFIX = "//";
    public static final String CUSTOM_SEPARATOR_PREFIX = "\\n";

    public static String[] split(String string) {
        String separator = Arrays.toString(STANDARD_SEPARATOR) + getCustomSeparator(string);
        String regex = "[" + separator + "]";
        string = string.substring(5);
        return string.split(regex);
    }

    public static Boolean hasCustomSeparator(String input){
        String temp = input.substring(0, 5);
        String suffix = temp.substring(0, 2);
        String prefix = temp.substring(3, 5);

        if (input.matches("\\d+"))
            return CUSTOM_SEPARATOR_PREFIX.equals(prefix) && CUSTOM_SEPARATOR_SUFFIX.equals(suffix);
        throw new IllegalArgumentException("커스텀 구분자는 숫자가 아니여야 합니다");
    }

    private static char getCustomSeparator(String string) {
        return string.substring(2, 3).charAt(0);
    }
}
