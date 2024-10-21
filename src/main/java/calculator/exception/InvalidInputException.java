package calculator.exception;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("입력 형식이 올바르지 않습니다.");
    }
}
