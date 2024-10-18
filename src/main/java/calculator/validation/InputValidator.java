package calculator.validation;

public class InputValidator {
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
