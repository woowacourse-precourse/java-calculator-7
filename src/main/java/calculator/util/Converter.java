package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> stringToNumbers(String input) {
        String expression = input;
        String delimiter = ",|:";

        if (expression.startsWith("//")) {
            int separatorIndex = expression.indexOf("\n");
            String customSeparator = expression.substring(2, separatorIndex);
            expression = expression.substring(separatorIndex + 1);
            delimiter += "|" + customSeparator;
        }

        String[] tokens = expression.split(delimiter);

        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
