package calculator;

import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public int[] parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new int[]{0};
        }

        String delimiter = "[,:]";
        String numbersStr = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);

                if (customDelimiter.matches("\\d")) {
                    throw new IllegalArgumentException();
                }

                delimiter = "[" + Pattern.quote(customDelimiter) + ",:]";
                numbersStr = matcher.group(2);
            } else {
                throw new IllegalArgumentException();
            }
        }

        try {
            return Stream.of(numbersStr.split(delimiter))
                    .map(String::trim)
                    .mapToInt(this::toInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int toInt(String numberStr) {
        return Integer.parseInt(numberStr);
    }
}