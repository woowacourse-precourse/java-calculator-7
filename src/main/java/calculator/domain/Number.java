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

    private void validateArithmeticNumber(String splitStr) {
        for (char s : splitStr.toCharArray()) {
            if (!String.valueOf(s).matches("[0-9]")) {
                throw new InvalidateArithmeticNumberException(splitStr);
            }
        }
    }

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
