package calculator.model.exception;

import calculator.common.exception.BusinessException;

import static calculator.common.message.ErrorMessage.LOWER_THAN_ZERO;

public class NotAllowedNumberException extends BusinessException {

    public NotAllowedNumberException() {
        super(LOWER_THAN_ZERO);
    }
}
