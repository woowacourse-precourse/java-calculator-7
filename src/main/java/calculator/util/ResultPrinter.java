package calculator.util;

import java.math.BigDecimal;

public class ResultPrinter {

    private ResultPrinter() {}

    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printResult(BigDecimal result) {
        System.out.println(RESULT_MESSAGE + formatBigDecimal(result));
    }

    private static String formatBigDecimal(BigDecimal value) {
        if (value.stripTrailingZeros().scale() <= 0) {
            return value.toBigInteger().toString();
        } else {
            return value.toString();
        }
    }
}
