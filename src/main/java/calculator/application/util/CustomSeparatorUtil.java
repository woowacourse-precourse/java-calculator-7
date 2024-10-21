package calculator.application.util;

public final class CustomSeparatorUtil {

    private CustomSeparatorUtil() {}

    public static boolean hasCustomSeparator(String text) {
        return text.contains("//") && text.contains("\\n");
    }

    public static String extractCustomSeparator(String text) {
        String separator = text.substring(2,3);
        return separator;
    }

    public static String extractExcludeCustomSeparator(String text) {
        String numbersInput = text.substring(5);
        return numbersInput;
    }
}
