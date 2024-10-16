package calculator.exception;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("입력 값은 최소 한 글자 이상의 문자열 혹은 '// ... \\n ...' 패턴의 문자열이어야 합니다.");
    }
}
