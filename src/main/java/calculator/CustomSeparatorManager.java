package calculator;

import java.util.regex.Pattern;

public class CustomSeparatorManager {
    private static final String CUSTOM_SEPARATOR_REGEX = "^//(\\S+)\\\\n";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);
    private static final String BLANK = "";

    private CustomSeparatorManager() {
    }

    public static boolean hasCustomSeparator(String inputString) {
        return PATTERN.matcher(inputString)
                .find();
    }

    public static Separator getCustomSeparator(String inputString) {
        return new Separator(PATTERN.matcher(inputString)
                .group(1));
    }

    public static String removeSeparatorDeclarationFrom(String inputString) {
        return PATTERN.matcher(inputString)
                .replaceFirst(BLANK);
    }
}
