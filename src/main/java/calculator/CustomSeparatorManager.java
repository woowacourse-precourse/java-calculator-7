package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorManager {
    private static final String CUSTOM_SEPARATOR_REGEX = "^//(\\S+)\\\\n";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);
    private static final String BLANK = "";
    private final Matcher matcher;
    private final boolean hasCustomSeparator;

    public CustomSeparatorManager(String targetString) {
        this.matcher = PATTERN.matcher(targetString);
        this.hasCustomSeparator = matcher.find();
    }

    public boolean hasCustomSeparator() {
        return hasCustomSeparator;
    }

    public Separator getCustomSeparator() {
        String customSeparatorString = matcher.group(1);
        return new Separator(customSeparatorString);
    }

    public String removeSeparatorDeclarationFrom() {
        return matcher.replaceFirst(BLANK);
    }
}
