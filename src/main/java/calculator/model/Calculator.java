package calculator.model;

import java.util.List;

public class Calculator {

    public Number add(List<Number> numbers) {
        double sum = 0.0;
        boolean hasFloatingPoint = false;

        for (Number number : numbers) {
            if (number instanceof Double) {
                hasFloatingPoint = true;
            }

            sum += number.doubleValue();
        }

        if (hasFloatingPoint) {
            return Double.parseDouble(String.format("%.1f", sum));
        } else {
            return (int) sum;
        }
    }
}
