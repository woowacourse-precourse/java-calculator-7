package calculator.config.exception;

public class BeanCreationException extends RuntimeException {
    private BeanCreationException(BeanErrorMessage errorMessage, Throwable cause) {
        super(errorMessage.getMessage(), cause);
    }

    public static BeanCreationException from(BeanErrorMessage errorMessage, Throwable cause) {
        return new BeanCreationException(errorMessage, cause);
    }

    private BeanCreationException(BeanErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static BeanCreationException from(BeanErrorMessage errorMessage) {
        return new BeanCreationException(errorMessage);
    }
}
