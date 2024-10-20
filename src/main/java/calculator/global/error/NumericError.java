package calculator.global.error;

public class NumericError extends IllegalArgumentException {

    private ErrorCode errorCode;

    public NumericError(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
    }
}