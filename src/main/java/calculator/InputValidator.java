package calculator;

public class InputValidator {

    public static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다. (input is null)");
        }
    }
}
