package calculator.controller;

public class Validation {

    public static boolean hasCustomDelimiter(String input) {
        if (input.matches("^(//.?\\n).*$")) {
            return true;
        }
        return false;
    }
}
