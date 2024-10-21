package calculator.utils;

public class StringUtils {
    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+");
    }

    public static int convert(String str) {
        return Integer.parseInt(str);
    }
}
