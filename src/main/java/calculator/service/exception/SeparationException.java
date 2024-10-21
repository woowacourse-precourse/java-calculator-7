package calculator.service.exception;

import calculator.exception.BaseException;
import calculator.exception.ExceptionType;

public class SeparationException extends BaseException {

    public SeparationException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
