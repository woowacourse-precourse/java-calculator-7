package calculator;

import calculator.exception.InvalidDelimiterException;

import java.util.Arrays;
import java.util.List;

public class CalculatorParser {
    public static List<Integer> parseInteger(String regex, String content) {
        try {
            return Arrays.stream(content.split(regex))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new InvalidDelimiterException();
        }
    }
}
