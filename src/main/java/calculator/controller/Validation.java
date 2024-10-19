package calculator.controller;

public class Validation {

    private static final String CUSTOM_DELIMITER_REGEX = "^(//.?\\n).*$";

    public static boolean hasCustomDelimiter(String input) {
        if (input.matches(CUSTOM_DELIMITER_REGEX)) {
            return true;
        }
        return false;
    }
}
