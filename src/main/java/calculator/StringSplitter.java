package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    private static final String defaultDelimiter = ",|:";

    public List<Integer> split(String input) {

        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        if (input.startsWith("//")) {
            String delimiter = extractDelimiter(input);
            String numbers = input.substring(input.indexOf("n") + 1);

            return splitNumbers(numbers, combineDelimiters(delimiter));
        }

        return splitNumbers(input, defaultDelimiter);
    }

    private String extractDelimiter(String input) {
        int newlineIndex = input.indexOf("\\");
        return input.substring(2, newlineIndex);
    }

    private String combineDelimiters(String customDelimiter) {

        String escapedCustomDelimiter = customDelimiter.replaceAll("([\\W])", "\\\\$1");
        return defaultDelimiter + "|" + escapedCustomDelimiter; // 기본 구분자와 커스텀 구분자를 OR 연산으로 결합
    }


    private List<Integer> splitNumbers(String input, String delimiter) {
        String[] tokens = input.split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                numbers.add(Integer.parseInt(token));
            }
        }
        return numbers;
    }
}
