package calculator.application.util.io.read;


final class InputValidator {

    private InputValidator() {}

    public static void validateNullAndEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
