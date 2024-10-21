package calculator.service;

public enum CustomSeparatorsRegex {
    START_SEPARATOR("//"), START_REGEX("^" + START_SEPARATOR.getRegex() + ".*"),
    MIDDLE_REGEX("\\D+"),
    END_SEPARATOR("\\n"), END_REGEX(".*\\" + END_SEPARATOR.getRegex() + ".*");

    private String regex;

    CustomSeparatorsRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
