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
        String suffix = input.substring(0, 2);
        String prefix = input.substring(3, 5);

        if(CUSTOM_SEPARATOR_PREFIX.equals(prefix) && CUSTOM_SEPARATOR_SUFFIX.equals(suffix)){
            validateCustomSeparator(String.valueOf(getCustomSeparator(input)));
            return true;
        }

        return false;
    }

    private static void validateCustomSeparator(String input) {
        if (input.matches("\\d+")) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아니여야 합니다");
        }
    }

    private static char getCustomSeparator(String string) {
        return string.substring(2, 3).charAt(0);
    }
}
