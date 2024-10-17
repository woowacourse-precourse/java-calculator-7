package calculator;

import java.util.regex.Matcher;
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
        Matcher matcher = PATTERN.matcher(inputString);
        matcher.find();
        String customSeparatorString = matcher.group(1);
        return new Separator(customSeparatorString);
    }

    public static String removeSeparatorDeclarationFrom(String inputString) {
        return PATTERN.matcher(inputString)
                .replaceFirst(BLANK);
    }
}
