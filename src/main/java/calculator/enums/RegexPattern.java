package calculator.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    BLANK_IN_START(Pattern.compile("^\\s.*")),
    BLANK_IN_END(Pattern.compile(".*\\s$"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
