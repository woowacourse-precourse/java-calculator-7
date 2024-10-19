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
        } else if (input.startsWith("//")) {
            validateCustomSeparator(input);
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

    private static void validateCustomSeparator(String input) {
        int index = input.indexOf("\\n");

        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (!Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException();
        }

        String separator = input.substring(2, index);

        if (separator.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (separator.length() > 1) {
            throw new IllegalArgumentException();
        } else if (Character.isDigit(separator.charAt(0))) {
            throw new IllegalArgumentException();
        }

        for (int i = index + 2; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!Character.isDigit(c) && c != separator.charAt(0)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
