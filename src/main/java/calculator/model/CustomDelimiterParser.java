package calculator.model;

import java.util.Optional;

public class CustomDelimiterParser {
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\\n";

    public static CustomDelimiterParser getInstance() {
        return new CustomDelimiterParser();
    }

    public Optional<String> parse(String input) {
        if (hasCustomDelimiter(input)) {
            return Optional.of(input.substring(getPrefixIndex(), getSuffixIndex(input)));
        }
        return Optional.empty();
    }

    public String excludeFromPrefixToSuffixBy(String input) {
        return input.substring(getSuffixIndex(input) + SUFFIX.length());
    }

    public boolean hasCustomDelimiter(String input) {
        if (isStartWithPrefix(input)) {
            return false;
        }
        return hasSuffix(input);
    }

    private boolean isStartWithPrefix(String input) {
        return !input.startsWith(PREFIX);
    }

    private boolean hasSuffix(String input) {
        return getSuffixIndex(input) != -1;
    }

    private int getPrefixIndex() {
        return PREFIX.length();
    }

    private int getSuffixIndex(String input) {
        return input.indexOf(SUFFIX);
    }
}
