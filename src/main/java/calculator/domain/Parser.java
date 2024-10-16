package calculator.domain;

import java.util.Arrays;
import java.util.List;

import static calculator.domain.Delimiter.getCustomDelimiter;

public class Parser {
    public static List<String> splitInput(String input) {
        StringBuilder delimiterBuilder = new StringBuilder("[:,");

        if (getCustomDelimiter(input) != null) {
            delimiterBuilder.append(getCustomDelimiter(input));
        }

        String delimiter = delimiterBuilder.append("]").toString();

        String numbers = removeCustomDelimiterPart(input);

        return Arrays.asList(numbers.split(delimiter));
    }

    public static String removeCustomDelimiterPart(String input) {
        if (Delimiter.getCustomDelimiter(input) != null) {
            int delimiterEndIndex = input.indexOf("\\n") + 1;

            return input.substring(delimiterEndIndex + 1);
        }

        return input;
    }
}
