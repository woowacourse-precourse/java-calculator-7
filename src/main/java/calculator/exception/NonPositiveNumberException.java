package calculator.exception;

public class NonPositiveNumberException extends IllegalArgumentException {
    public NonPositiveNumberException() {
        super("입력값 중 숫자는 양수여야 합니다.");
    }
}
