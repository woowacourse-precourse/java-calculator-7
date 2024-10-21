package calculator.model;

import java.math.BigDecimal;
import java.util.List;

public class CalculateService {

    public BigDecimal sum(List<BigDecimal> numbers) {
        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
