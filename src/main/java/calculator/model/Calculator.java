package calculator.model;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    public Number add(List<Number> numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        boolean containsFloat = false;

        for (Number number : numbers) {
            if (number instanceof Double) {
                containsFloat = true;
            }

            sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
        }

        if (containsFloat) {
            return sum.stripTrailingZeros();
        } else {
            return sum.intValue();
        }
    }
}
