package calculator.util;

public class Validator {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
