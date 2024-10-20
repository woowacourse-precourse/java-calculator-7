package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<Integer> stringToNumbers(String string) {
        String expression = string;
        String customSeparator = "";

        if (expression.startsWith("//")) {
            int separatorIndex = expression.indexOf("\n");
            customSeparator = expression.substring(2, separatorIndex);
            expression = expression.substring(separatorIndex + 1);
        }

        String delimiter = ",|:";
        if (!customSeparator.isEmpty()) {
            delimiter += "|" + customSeparator;
        }

        String[] tokens = expression.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }

        return numbers;
    }
}
