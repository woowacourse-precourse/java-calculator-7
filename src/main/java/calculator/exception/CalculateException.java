package calculator.exception;

public class CalculateException {

    private static final Integer ZERO = 0;

    public static void throwException(ExceptionMessage exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage.getExceptionMessage());
    }

    public static void catchNumberNotPositiveException(Integer number) {
        if (number < ZERO) {
            throwException(ExceptionMessage.INPUT_IS_NOT_POSITIVE_EXCEPTION);
        }
    }

    public static Integer catchNumberFormatException(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throwException(ExceptionMessage.INPUT_IS_NOT_NUMBER_EXCEPTION);
        }
        return null;
    }
}
