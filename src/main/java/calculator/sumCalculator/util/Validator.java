package calculator.sumCalculator.util;

import calculator.common.exception.ExceptionCode;

import java.util.List;

public class Validator {

    public static void validatePositive(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 0)) {
            throw new IllegalArgumentException(ExceptionCode.NUMBER_INVALID_NEGATIVE.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num == 0)) {
            throw new IllegalArgumentException(ExceptionCode.NUMBER_INVALID_ZERO.getMessage());
        }
    }
}
