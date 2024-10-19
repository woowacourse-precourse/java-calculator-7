package calculator.exception;

public class InputValidationException extends IllegalArgumentException{
    public InputValidationException(String message) {
        super(message);
    }

    public static void isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 애플리케이션을 종료합니다.");
        }
    }
}
