package calculator;

import calculator.domain.Delimiters;
import calculator.domain.Operands;
import java.util.List;

public enum ExpressionTestCase {

    NO_CUSTOM_DELIMITER(
            "123:234,345,456",
            "123:234,345,456",
            Delimiters.of(",", ":"),
            Operands.of(List.of("123", "234", "345", "456"))),
    SINGLE_CUSTOM_DELIMITER(
            "//?\\n123:234?345,456",
            "123:234?345,456",
            Delimiters.of(",", ":", "?"),
            Operands.of(List.of("123", "234", "345", "456"))),
    MULTIPLE_CUSTOM_DELIMITER(
            "//?\\n//w\\n123:  234 ? 345  w456",
            "123:  234 ? 345  w456",
            Delimiters.of(",", ":", "?", "w"),
            Operands.of(List.of("123", "234", "345", "456")));

    public final String str;
    public final String expr;
    public final Delimiters delimiters;
    public final Operands operands;
    public int sum = 0;

    ExpressionTestCase(final String str, final String expr,
                       final Delimiters delimiters, final Operands operands) {
        this.str = str;
        this.expr = expr;
        this.delimiters = delimiters;
        this.operands = operands;

        for (String operand : operands.toList()) {
            sum += Integer.parseInt(operand);
        }
    }
}
