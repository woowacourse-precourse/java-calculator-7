package calculator.model.exception;

import calculator.common.exception.BusinessException;

import static calculator.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

public class ShouldNotBeNullException extends BusinessException {
    public ShouldNotBeNullException() {
        super(SHOULD_NOT_BE_NULL);
    }
}
