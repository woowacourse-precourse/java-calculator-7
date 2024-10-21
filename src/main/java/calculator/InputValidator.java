package calculator;

public class InputValidator {

    public static void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있거나 null입니다.");
        }
    }
}