package delimiter;

import java.util.regex.Pattern;

public enum DelimiterPattern {

    CUSTOM_DELIMITER("//(.+?)\\\\n");

    private final String regex;
    private final Pattern pattern;

    DelimiterPattern(final String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public String getRegex() {
        return regex;
    }

    public Pattern getPattern() {
        return pattern;
    }

}
