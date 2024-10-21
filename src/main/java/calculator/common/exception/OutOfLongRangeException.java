package calculator.common.exception;

import calculator.common.constant.ErrorMessage;

public class OutOfLongRangeException extends RuntimeException {
    public OutOfLongRangeException(Long sum, Long number, Exception e) {
        super(ErrorMessage.NUMBERS_RANGE + "[기존 합계 : " + sum + " 더하려는 값 : " + number + "]", e);
    }

    public OutOfLongRangeException(String str, Exception e) {
        super(ErrorMessage.NUMBERS_RANGE + "[Long 타입으로 변환을 시도한 문자열 : " + str + "]", e);
    }
}
