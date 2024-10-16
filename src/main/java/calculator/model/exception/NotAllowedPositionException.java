package calculator.model.exception;

import calculator.common.exception.BusinessException;

import static calculator.common.message.ErrorMessage.CHECKER_POSITION;

public class NotAllowedPositionException extends BusinessException {
    public NotAllowedPositionException() {
        super(CHECKER_POSITION);
    }
}