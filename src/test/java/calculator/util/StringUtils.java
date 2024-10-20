package calculator.util;

public class StringUtils {

    public static String unescapeDoubleBackslashes(String input) {
        return input.replace("\\\\", "\\");
    }
}
