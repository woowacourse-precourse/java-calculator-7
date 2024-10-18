package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Operator {
    public BigDecimal add(List<BigDecimal> operands) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal operand : operands) {
            result = result.add(operand);
        }
        return result;
    }
}
