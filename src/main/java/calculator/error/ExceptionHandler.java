package calculator.error;

public class ExceptionHandler {

    public void handleException(Exception error) {
        if (error instanceof IllegalArgumentException) {
            handleIllegalArgumentException((IllegalArgumentException) error);
        }
    }
    private void handleIllegalArgumentException(IllegalArgumentException e) {
        throw new IllegalArgumentException();
    }
}
