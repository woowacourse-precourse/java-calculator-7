package calculator.model;

public class InputValidator {

    public static void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null일 수 없습니다.");
        }
    }

    public static void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }

    public static void validateIsNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + token);
        }

    }

}
