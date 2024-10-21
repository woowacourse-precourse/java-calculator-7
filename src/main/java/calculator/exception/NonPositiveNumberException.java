package calculator.exception;

import java.math.BigInteger;

public class NonPositiveNumberException extends IllegalArgumentException {

    public NonPositiveNumberException(BigInteger number) {
        super("양수가 아닙니다.: " + number.toString());
    }
}
