package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_CONTENT = "구분자와 양수만 입력 가능합니다.";

    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public static Calculator from(String input) {
        input = input.replace("\\n", "\n");
        Matcher matcher = Pattern.compile(REGEX, Pattern.DOTALL).matcher(input);

        String delimiters = DEFAULT_DELIMITERS;
        String inputNumbers = input;

        if (matcher.matches()) {
            delimiters = Pattern.quote(matcher.group(1));
            inputNumbers = matcher.group(2);
        }

        List<Integer> numbers = parseNumbers(inputNumbers, delimiters);
        return new Calculator(numbers);
    }

    private static List<Integer> parseNumbers(String numbers, String delimiters) {
        List<Integer> result = new ArrayList<>();
        for (String token : numbers.split(delimiters)) {
            try {
                if (Objects.equals(token, "")) {
                    continue;
                }
                result.add(Integer.parseInt(token));
                if (result.getLast() <= 0) {
                    throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_CONTENT);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_CONTENT);
            }
        }
        return result;
    }
}
