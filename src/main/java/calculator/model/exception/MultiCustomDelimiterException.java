package calculator.model.exception;

import calculator.common.exception.BusinessException;

import static calculator.common.message.ErrorMessage.MULTI_DELIMITER;

public class MultiCustomDelimiterException extends BusinessException {
    public MultiCustomDelimiterException() {
        super(MULTI_DELIMITER);
    }
}
