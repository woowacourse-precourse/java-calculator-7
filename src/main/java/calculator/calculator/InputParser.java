package calculator.calculator;

import java.util.regex.Pattern;

public class InputParser {
    public static String[] parse(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            String delimiterPart = input.substring(2, delimiterEndIndex);
            delimiter = extractMultipleDelimiters(delimiterPart);
            input = input.substring(delimiterEndIndex + 2);
        }

        return input.split(delimiter);
    }

    private static String extractMultipleDelimiters(String delimiterPart) {
        StringBuilder delimiterBuilder = new StringBuilder();

        for (char c : delimiterPart.toCharArray()) {
            delimiterBuilder.append(Pattern.quote(String.valueOf(c))).append("|");
        }

        if (delimiterBuilder.length() > 0) {
            delimiterBuilder.setLength(delimiterBuilder.length() - 1);
        }

        return delimiterBuilder.toString();
    }
}
