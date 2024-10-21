package calculator.stringcalculator;

import java.math.BigDecimal;
import java.util.List;

public class SumCalculator {

    public BigDecimal sumNumber(List<BigDecimal> numbers) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (BigDecimal number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
