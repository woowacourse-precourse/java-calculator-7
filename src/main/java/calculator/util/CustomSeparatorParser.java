package calculator.util;


public class CustomSeparatorParser {


    public static final String CUSTOM_SEPARATOR_SUFFIX = "//";
    public static final String CUSTOM_SEPARATOR_PREFIX = "\\n";

    public static Boolean hasCustomSeparator(String input) {
        String suffix = input.substring(0, 2);
        String prefix = input.substring(3, 5);

        return CUSTOM_SEPARATOR_PREFIX.equals(prefix) && CUSTOM_SEPARATOR_SUFFIX.equals(suffix);
    }

    private static void validateCustomSeparator(String input) {
        if (input.matches("\\d+")) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아니여야 합니다");
        }
    }

    public static char getCustomSeparator(String input) {
        char separator = input.charAt(3);
        validateCustomSeparator(String.valueOf(separator));
        return separator;
    }
}
