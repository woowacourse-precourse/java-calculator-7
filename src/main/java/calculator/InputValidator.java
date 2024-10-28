package calculator;

public class InputValidator {

    public boolean isEmptyOrNull(String input) {
        return input == null || input.trim().isEmpty();
    }

    public void validateIsNumeric(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public void validateInRange(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("값이 int 범위를 초과했습니다.");
        }
    }

    public void validateNonNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
