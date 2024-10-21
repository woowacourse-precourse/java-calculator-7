package calculator.model;

import static calculator.model.enums.ExceptionMessage.NUMERIC_EXCEPTION;
import static calculator.model.enums.ExceptionMessage.RANGE_EXCEPTION;
import static calculator.util.Converter.convertToInteger;

// 문자열에서 분리된 각 숫자를 담는 객체
public class Number {
    private final int number;

    private static final int NUMBER_RANGE_CONDITION = 1;

    public Number(String number) {
        validate(number);
        this.number = convertToInteger(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String number) {
        validateNumeric(number);
        validateRange(number);
    }

    // 숫자가 아니라면 예외를 던지는 메서드
    private void validateNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_EXCEPTION.getMessage());
        }
    }

    // 양의 정수가 아니라면 예외를 던지는 메서드
    private void validateRange(String number) {
        if (Integer.parseInt(number) < NUMBER_RANGE_CONDITION) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
        }
    }
}
