package calculator.common.exception;

public class ExceptionFactory {

    public static RuntimeException createException(ExceptionType exceptionType) {
        try {
            return exceptionType.getExceptionClass()
                    .getConstructor(String.class)
                    .newInstance(exceptionType.getMessage());
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("예외를 만드는 데에 실패했습니다.", e);
        }
    }
}
