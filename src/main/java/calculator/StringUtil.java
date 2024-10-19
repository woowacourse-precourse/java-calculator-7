package calculator;

public class StringUtil {
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean hasCustomDelimiter(String input) {
        return input.charAt(0) == '/' && input.charAt(1) == '/'
                && input.charAt(3) == '\\' && input.charAt(4) == 'n';
    }

    public static char getCustomDelimiter(String input) {
        return input.charAt(2);
    }
}
