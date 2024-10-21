package calculator.common.exception;

import calculator.common.constant.ErrorMessage;

public class InvalidateArithmeticNumberException extends RuntimeException {
    public InvalidateArithmeticNumberException(String nonArithmeticNumber) {
        super(ErrorMessage.CALCULATE_ONLY_NUMBERS + "[숫자가 아닌 문자열 : " + nonArithmeticNumber + "]");
    }
}
