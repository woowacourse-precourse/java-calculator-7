package calculator.domain.vo.exception;

public class NegativeException extends IllegalArgumentException{
    public NegativeException() {
        super("음수는 허용되지 않습니다.");
    }
}
