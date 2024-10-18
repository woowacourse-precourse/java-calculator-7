package calculator.exception;

public class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException() {
        super("숫자는 양의 정수만 입력할 수 있습니다.");
    }
}
