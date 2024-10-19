package calculator.util;

import java.util.regex.Pattern;

public class SeparatorProcessor {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    public static String getSeparators(String input) {
        if (hasCustomSeparator(input)) {
            int separatorEndIndex = getSeparatorEndIndex(input);
            validateCustomSeparator(separatorEndIndex);

            String customSeparator = getCustomSeparator(input, separatorEndIndex);

            return COMMA + "|" + COLON + "|" + Pattern.quote(customSeparator);
        }

        return COMMA + "|" + COLON;
    }

    public static String getNumbers(String input) {
        if (hasCustomSeparator(input)) {
            int separatorEndIndex = getSeparatorEndIndex(input);
            return input.substring(separatorEndIndex + 2);
        }

        return input;
    }

    private static boolean hasCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private static void validateCustomSeparator(int customSeparatorEndIndex) {
        if (customSeparatorEndIndex == -1) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    private static int getSeparatorEndIndex(String input) {
        return input.indexOf("\\n");
    }

    private static String getCustomSeparator(String input, int separatorEndIndex) {
        return input.substring(2, separatorEndIndex);
    }
}
