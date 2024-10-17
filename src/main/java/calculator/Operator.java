package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Operator {
    public BigDecimal add(List<BigDecimal> operands) {
        BigDecimal result = BigDecimal.ZERO;
        operands.forEach(result::add);
        return result;
    }
}
