package calculator.domain;

import calculator.common.exception.InvalidateArithmeticNumberException;
import calculator.common.exception.OutOfLongRangeException;
import java.util.Objects;

public class Number {

    private final Long numberValue;

    public Number(String splitStr) {
        validateArithmeticNumber(splitStr);
        this.numberValue = convertToLong(splitStr);
    }

    /*
     * 문자열이 모두 0~9 사이의 숫자로 이루어져 있는지를 확인한다.
     */
    private void validateArithmeticNumber(String splitStr) {
        for (char s : splitStr.toCharArray()) {
            if (!String.valueOf(s).matches("[0-9]")) {
                throw new InvalidateArithmeticNumberException(splitStr);
            }
        }
    }

    /*
     * String 타입의 변수를 long 타입 숫자로 변환한다.
     * 이때 숫자가 long 타입 범위를 벗어나면 예외를 발생시킨다.
     */
    private Long convertToLong(String splitStr) {
        long number = 0L;
        try {
            number = Long.parseLong(splitStr);
        } catch (NumberFormatException e) {
            throw new OutOfLongRangeException(splitStr, e);
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return Objects.equals(numberValue, number.numberValue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numberValue);
    }

    public Long getNumberValue() {
        return numberValue;
    }
}
