package calculator;

import java.math.BigDecimal;
import java.util.List;

public class SumCalculator {

    private final List<String> strings;

    public SumCalculator(List<String> strings) {
        this.strings = strings;
    }

    public String calculateSum() {
        BigDecimal sum = strings.stream()
                .map(str -> convertToBigDecimal(str))
                .reduce(new BigDecimal("0"), (o1, o2) -> o1.add(o2));

        return sum.toString();
    }

    private BigDecimal convertToBigDecimal(String str) {
        if (str.equals("0")) {
            throw new IllegalArgumentException(strings.toString());
        }
        if (!str.matches("^[+]?[0-9]+")) {
            throw new IllegalArgumentException(strings.toString());
        }
        return new BigDecimal(str);
    }
}
