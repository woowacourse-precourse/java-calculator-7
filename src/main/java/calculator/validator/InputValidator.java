package calculator.validator;

public class InputValidator {
    public void validate(String input) {
        if (input.contains("-") && !input.startsWith("//-")) {
            // 커스텀 구분자가 아닌 음수일 경우 예외 발생
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
