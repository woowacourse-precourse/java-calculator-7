package calculator.model;

public class InputValidator {
    public void validate(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열 또는 null은 허용되지 않습니다.");
        }
    }
}
