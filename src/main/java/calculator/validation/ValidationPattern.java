package calculator.validation;

import java.util.regex.Pattern;

public enum ValidationPattern {
    CUSTOM_DELIMITER_PATTERN("^//(.{1,5})\\\\n"),
    INTEGER_PATTERN("\\d+");

    private final Pattern pattern;

    ValidationPattern(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}


