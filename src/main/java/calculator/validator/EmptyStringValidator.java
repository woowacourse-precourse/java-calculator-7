package calculator.validator;

public class EmptyStringValidator {
    public static boolean isEmptyString(String[] input) {
        return input == null || input.length == 0;
    }

    public static boolean isEmptyString(String input) {
        return input == null || input.trim().isEmpty();
    }
}
