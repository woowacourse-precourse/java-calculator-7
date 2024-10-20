package calculator.exception;

public class NonNumericCharacterException extends RuntimeException {
    public NonNumericCharacterException(char c) {
        super(c + "는 0~9 사이의 숫자가 아닙니다.");
    }
}
