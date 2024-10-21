package calculator.util;

import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalArrayConverter {

    private BigDecimalArrayConverter() {}

    public static BigDecimal[] convert(String[] s) {
        try {
            return Arrays.stream(s)
                .map(BigDecimal::new)
                .toArray(BigDecimal[]::new);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 입력만 가능합니다.");
        }
    }
}
