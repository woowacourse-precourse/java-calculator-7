package calculator.model.exception;

import calculator.common.exception.BusinessException;

import static calculator.common.message.ErrorMessage.CAN_NOT_PARSE;

public class ParseToIntegerFailedException extends BusinessException {
    public ParseToIntegerFailedException() {
        super(CAN_NOT_PARSE);
    }
}
