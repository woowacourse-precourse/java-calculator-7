package calculator.service;

public enum CustomSeparatorsRegex {
    START_REGEX("^//"), MIDDLE_REGEX("\\D"), END_REGEX("\n");

    private String regex;

    CustomSeparatorsRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
