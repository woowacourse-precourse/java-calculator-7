package calculator.config.exception;

public class BeanSearchException extends IllegalArgumentException {
    private BeanSearchException(BeanErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static BeanSearchException from(BeanErrorMessage errorMessage) {
        return new BeanSearchException(errorMessage);
    }
}
