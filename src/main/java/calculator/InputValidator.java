package calculator;

public class InputValidator {

    // 입력 값이 비어있는지 검증
    public boolean isEmptyOrNull(String input) {
        return input == null || input.trim().isEmpty();
    }

    // 숫자인지 확인하는 메서드
    public void validateIsNumeric(String token) {
        try {
            Integer.parseInt(token);  // 숫자 변환 시도
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    // int 범위 내에 속하는지 확인하는 메서드
    public void validateInRange(String token) {
        try {
            Integer.parseInt(token);  // 숫자 변환 시도
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("값이 int 범위를 초과했습니다.");
        }
    }

    // 음수가 아닌지 확인하는 메서드
    public void validateNonNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
