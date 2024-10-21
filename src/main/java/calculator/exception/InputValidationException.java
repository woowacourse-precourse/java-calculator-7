package calculator.exception;

public class InputValidationException extends IllegalArgumentException{
    public InputValidationException(String message) {
        super(message);
    }

    public static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 애플리케이션을 종료합니다.");
        }
        return false;
    }

    public static boolean isPositiveNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
        }
        return true;
    }
}
