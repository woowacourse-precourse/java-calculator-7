package calculator.exception;

public class InvalidInputStrException extends RuntimeException {
    public InvalidInputStrException(String inputStr) {
        super(inputStr + "은 올바르지 않은 사용자 입력입니다.");
    }
}
