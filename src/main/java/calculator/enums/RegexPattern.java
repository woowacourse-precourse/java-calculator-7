package calculator.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegexPattern {
    BLANK_IN_START(Pattern.compile("^\\s.*")),
    BLANK_IN_END(Pattern.compile(".*\\s$")),
    CONTAINS_NUMERIC(Pattern.compile(".*\\d+.*")),
    CUSTOM_DELIMITER_DECLARATION(Pattern.compile("//(.*?)\\\\n")),
    FIRST_NUMBER_PATTERN(Pattern.compile("\\d"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }

    public Matcher matcher(String input) {
        return pattern.matcher(input);
    }
}
