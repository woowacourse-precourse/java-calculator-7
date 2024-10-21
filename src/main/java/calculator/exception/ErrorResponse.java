package calculator.exception;

public class ErrorResponse {
    private String message;
    private ErrorResponse(final ErrorCode code) {
        this.message = code.getMessage();
    }
}
