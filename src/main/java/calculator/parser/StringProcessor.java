package calculator.parser;


public class StringProcessor {
    public static boolean isEmpty(String str) {
        return str.trim().isEmpty();
    }

    public static String trim(String str) {
        return str.trim();

    }

    public static boolean isNotEmpty(String str) {
        return !str.trim().isEmpty();
    }
}
