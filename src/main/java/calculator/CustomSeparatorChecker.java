package calculator;

import java.util.regex.Pattern;

public class CustomSeparatorChecker {
    private static final String CUSTOM_SEPARATOR_REGEX = "^//\\S+\\\\n";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    private CustomSeparatorChecker() {
    }

    public static boolean hasCustomSeparator(String inputString) {
        return PATTERN.matcher(inputString)
                .find();
    }
}
