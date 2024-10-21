package calculator.common.exception;


import calculator.common.constant.ErrorMessage;

public class InvalidSeparatorException extends RuntimeException {
    public InvalidSeparatorException(Character separator) {
        super(ErrorMessage.DELIMITER_MUST_BE_CHARACTER + "[유효하지 않은 구분자 : " + separator + "]");
    }
}
