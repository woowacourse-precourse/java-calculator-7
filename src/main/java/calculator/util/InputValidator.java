package calculator.util;

public class InputValidator {
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        // 추가적인 유효성 검사 규칙을 여기에 구현할 수 있습니다.
    }
}
