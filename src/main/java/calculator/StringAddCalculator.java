package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private final Converter converter = new Converter();
    private final NumberFormatter numberFormatter = new NumberFormatter();

    public String add(String input) {
        if (input.isEmpty()) {
            return "0";
        }

        return numberFormatter.format(Arrays.stream(converter.toStringArr(input))
                .mapToDouble(Double::parseDouble)
                .sum());
    }
}