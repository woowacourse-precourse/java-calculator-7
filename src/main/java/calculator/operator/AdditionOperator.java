package calculator.operator;

import java.math.BigDecimal;

public class AdditionOperator implements Operator {

    @Override
    public BigDecimal calculate(BigDecimal[] numbers) {
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            validatePositiveNumber(number);
            total = total.add(number);
        }
        return total;
    }

    private void validatePositiveNumber(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("양수만 가능합니다.");
        }
    }
}
