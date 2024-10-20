package calculator.error;

public class CustomException extends IllegalArgumentException {
    private String message;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

    public static CustomException create(ErrorCode errorCode) {
        return new CustomException(errorCode);
    }
}