package calculator.domain;

import java.math.BigDecimal;

public class Number {
    private final BigDecimal value;

    public Number(BigDecimal value) {
        this.value = value;
    }

    public static Number createByString(String str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            return new Number(bigDecimal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
