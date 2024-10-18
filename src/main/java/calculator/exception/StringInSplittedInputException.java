package calculator.exception;

public class StringInSplittedInputException extends IllegalArgumentException {
    public StringInSplittedInputException() {
        super("분리된 입력값에 문자열이 존재합니다.");
    }
}
