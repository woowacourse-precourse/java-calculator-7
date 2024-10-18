package calculator.validation;

public class InputValidator {
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        // 커스텀 구분자가 있는 경우 검증
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length != 2 || parts[0].length() != 3) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
        }
    }
}
