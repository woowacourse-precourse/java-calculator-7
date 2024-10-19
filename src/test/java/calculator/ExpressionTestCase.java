package calculator;

import java.util.List;
import java.util.Set;

public enum ExpressionTestCase {

    NO_CUSTOM_DELIMITER(
            "123:234,345,456",
            "123:234,345,456",
            Set.of(",", ":"),
            List.of("123", "234", "345", "456")),
    SINGLE_CUSTOM_DELIMITER(
            "//?\\n123:234?345,456",
            "123:234?345,456",
            Set.of(",", ":", "?"),
            List.of("123", "234", "345", "456")),
    MULTIPLE_CUSTOM_DELIMITER(
            "//?\\n//w\\n123:  234 ? 345  w456",
            "123:  234 ? 345  w456",
            Set.of(",", ":", "?", "w"),
            List.of("123", "234", "345", "456"));

    public final String str;
    public final String expr;
    public final Set<String> delimiters;
    public final List<String> operands;
    public int sum = 0;

    ExpressionTestCase(final String str, final String expr,
                       final Set<String> delimiters, final List<String> operands) {
        this.str = str;
        this.expr = expr;
        this.delimiters = delimiters;
        this.operands = operands;

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }
    }
}
