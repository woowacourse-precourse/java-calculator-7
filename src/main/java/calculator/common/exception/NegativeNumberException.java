package calculator.common.exception;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String NEGATIVE_NUMBER = "음수는 입력할 수 없습니다: ";

    public NegativeNumberException(String token) {
        super(NEGATIVE_NUMBER + token);
    }
}
