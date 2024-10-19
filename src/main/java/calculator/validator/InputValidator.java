package calculator.validator;

public class InputValidator {
    public static void validateInput(String input) {
        if (input.isEmpty()) {
            return;
        }

        if (!input.startsWith("//") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }
}
