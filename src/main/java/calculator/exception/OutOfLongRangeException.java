package calculator.exception;

public class OutOfLongRangeException extends RuntimeException {
    public OutOfLongRangeException(Long sum, Long number, Exception e) {
        super(sum + "에 " + number + "를 더하면 Long 타입 범위를 벗어납니다.", e);
    }
}
