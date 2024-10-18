package calculator.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    CUSTOM_DELIMITER(Pattern.compile("^//(.)\\\\n")),
    ONLY_COMMA_COLON_DELIMITER(Pattern.compile("^[0-9]+([,:][0-9]+)*$"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean find(String input) {
        return pattern.matcher(input).find();
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
