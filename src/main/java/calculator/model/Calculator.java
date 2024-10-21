package calculator.model;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    public BigDecimal add(List<BigDecimal> numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
