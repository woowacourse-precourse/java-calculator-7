package calculator.validator;

public class InputValidator {
    public static void validateInput(String input) {
        if (input.isEmpty()) {
            return;
        }

        if (!input.startsWith("//") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }

        if (Character.isDigit(input.charAt(0))) {
            validateBasicSeparator(input);
        }
    }

    private static void validateBasicSeparator(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!Character.isDigit(c) && c != ',' && c != ':') {
                throw new IllegalArgumentException();
            }

            if (i == input.length() - 1 && !Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
