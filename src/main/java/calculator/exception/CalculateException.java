package calculator.exception;

public class CalculateException {

    public static void throwException(ExceptionMessage exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage.getExceptionMessage());
    }

    public static void catchNumberNotPositiveException() {
        throwException(ExceptionMessage.INPUT_IS_NOT_POSITIVE_EXCEPTION);
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
