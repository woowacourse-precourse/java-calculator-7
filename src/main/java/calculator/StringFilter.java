package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringFilter {
    private final String processedInput;
    private final Set<Character> delimiters;

    public StringFilter(String processedInput, Set<Character> delimiters) {
        this.processedInput = processedInput;
        this.delimiters = delimiters;
    }

    public List<Integer> extractNumbers() {
        if (processedInput.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiterRegex = createDelimiterRegex();
        String[] numberStrings = processedInput.split(delimiterRegex);

        return convertToIntegers(numberStrings);
    }

    private String createDelimiterRegex() {
        return delimiters.stream()
                .map(ch -> Pattern.quote(String.valueOf(ch)))
                .collect(Collectors.joining("|"));
    }

    private List<Integer> convertToIntegers(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrings) {
            if (numberStr.isEmpty()) continue;

            int number = Integer.parseInt(numberStr.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            numbers.add(number);
        }
        return numbers;
    }
}