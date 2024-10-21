package calculator.operator;

import java.math.BigDecimal;

public interface Operator {
    BigDecimal calculate(BigDecimal[] numbers);
}
