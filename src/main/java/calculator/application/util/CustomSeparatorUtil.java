package calculator.application.util;

public final class CustomSeparatorUtil {

    private CustomSeparatorUtil() {}

    public static boolean hasCustomSeparator(String text) {
        return text.contains("//") && text.contains("\\n");
    }

}
