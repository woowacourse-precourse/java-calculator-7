package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static List<Number> splitAndParse(String input, List<String> delimiters) {
        String delimiterPattern = delimiters.stream()
                .map(java.util.regex.Pattern::quote)
                .collect(Collectors.joining("|"));

        return Arrays.stream(input.split(delimiterPattern))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static int calculateSum(List<Number> numbers) {
        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
