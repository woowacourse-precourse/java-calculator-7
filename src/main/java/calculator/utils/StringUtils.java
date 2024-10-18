package calculator.utils;

public class StringUtils {
    public static boolean isEmptyString(String inputString) {
        return inputString.length() == 0;
    }

    public static char getFirstChar(String inputString) {
        return inputString.charAt(0);
    }
}
