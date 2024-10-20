package calculator.common.exception;

import calculator.common.constant.ErrorMessage;

public class ContainsBlankException extends RuntimeException {
    public ContainsBlankException(String inputStr) {
        super(ErrorMessage.INPUT_MUST_NOT_CONTAIN_BLANK + "[사용자 입력 : " + inputStr + "]");
    }
}
