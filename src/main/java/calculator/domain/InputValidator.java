package calculator.domain;

import static calculator.exception.Exception.INVALID_NEGATIVE_NUMBER;
import static calculator.exception.Exception.INVALID_NUMBER_FORMAT;
import static calculator.exception.Exception.INVALID_NUMBER_SIZE;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class InputValidator {
    // 전체 입력 리스트를 검증
    public void validate(List<String> stringInputs) {
        for (String s : stringInputs) {
            validateNumberFormat(s);
            validatePositiveNumber(s);
            validateNumberSize(s);
        }
    }

    // 문자열 : 정수인지 확인
    private void validateNumberFormat(String s) {
        try {
            new BigInteger(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage() + s);
        }
    }

    // 문자열 : 양수인지 확인
    private void validatePositiveNumber(String s) {
        BigInteger value = new BigInteger(s);
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER.getMessage() + s);
        }
    }

    // 정수 크기가 Integer 범위를 넘어가는지 확인
    private void validateNumberSize(String s) {
        BigInteger value = new BigInteger(s);
        if (value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage() + s);
        }
    }
}
