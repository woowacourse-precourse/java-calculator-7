package calculator.domain.vo.exception;

public class NullEmptyException extends IllegalArgumentException {
    public NullEmptyException() {
        super("null값이거나 빈 값일 수 없다.");
    }
}
