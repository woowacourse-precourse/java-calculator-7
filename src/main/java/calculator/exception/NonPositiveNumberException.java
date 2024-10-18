package calculator.exception;

public class NonPositiveNumberException extends IllegalArgumentException {
    public NonPositiveNumberException() {
        super("입력값 중 숫자는 0보다 커야합니다.");
    }
}
