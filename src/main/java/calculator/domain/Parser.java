package calculator.domain;

import static calculator.domain.Delimiter.getCustomDelimiter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Parser {
    public static List<String> splitInput(String input) {
        String delimiter = makeDelimiter(input);

        String numbers = removeCustomDelimiterPart(input);

        if (!isIncludeDelimiter(input)) {
            throw new IllegalArgumentException("구분자를 입력해 주세요.");
        }

        return Arrays.asList(numbers.split(delimiter));
    }

    private static boolean isIncludeDelimiter(String input) {
        return input.contains(",") || input.contains(":") || input.contains(
                Objects.requireNonNull(getCustomDelimiter(input)));
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
