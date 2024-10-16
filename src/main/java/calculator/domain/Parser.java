package calculator.domain;

import static calculator.domain.Delimiter.getCustomDelimiter;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> splitInput(String input) {
        String delimiter = makeDelimiter(input);

        String numbers = removeCustomDelimiterPart(input);

        return Arrays.asList(numbers.split(delimiter));
    }

    private static String makeDelimiter(String input) {
        StringBuilder delimiterBuilder = new StringBuilder("[:,");

        if (getCustomDelimiter(input) != null) {
            delimiterBuilder.append(getCustomDelimiter(input));
        }

        return delimiterBuilder.append("]").toString();
    }

    private static String removeCustomDelimiterPart(String input) {
        if (Delimiter.getCustomDelimiter(input) != null) {
            int delimiterEndIndex = input.indexOf("\\n") + 1;

            return input.substring(delimiterEndIndex + 1);
        }

        return input;
    }
}
