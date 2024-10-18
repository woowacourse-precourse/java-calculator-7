package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleParser implements Parser {
    public static final String INPUT_DELIMITERS_PATTERN = "^//.*\\\\n";
    public static final String DEFAULT_DELIMITERS = "[,:]";

    public static final String ERR_MSG_WHEN_NEGATIVE_NUMBER = "음수는 입력할 수 없습니다.";
    public static final String ERR_MSG_WHEN_FAIL_TO_PARSE_INT = "숫자가 아닌 값이 입력되었습니다.";

    @Override
    public List<Integer> parse(String input) {
        DelimitersAndNumbers delimitersAndNumbers = separateInput(input);
        String delimiters = delimitersAndNumbers.delimiters();
        String numbers = delimitersAndNumbers.numbers();

        if (numbers.isEmpty()) {
            return List.of();
        }

        List<String> numbersStr = Arrays.stream(numbers.split(delimiters, -1)).toList();
        List<Integer> numbersInt = mapNumbersFromStrToInt(numbersStr);

        validateNumbers(numbersInt);
        return numbersInt;
    }

    private DelimitersAndNumbers separateInput(String input) {
        Pattern delimiterPattern = Pattern.compile(INPUT_DELIMITERS_PATTERN);
        Matcher delimiterMatcher = delimiterPattern.matcher(input);

        if (!delimiterMatcher.find()) {
            return new DelimitersAndNumbers(DEFAULT_DELIMITERS, input);
        }

        // TODO: improve readability
        // It's hard to understand why the first two letters and the last one have to be removed.
        String matched = delimiterMatcher.group();
        String delimiters = "[" + matched.substring(2, matched.length() - 2) + "]";
        String numbers = input.substring(matched.length());
        return new DelimitersAndNumbers(delimiters, numbers);
    }

    private List<Integer> mapNumbersFromStrToInt(List<String> numbersStr) {
        try {
            return numbersStr.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException _ignored) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_FAIL_TO_PARSE_INT);
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 0)) {
            throw new IllegalArgumentException(ERR_MSG_WHEN_NEGATIVE_NUMBER);
        }
    }

    private record DelimitersAndNumbers(String delimiters, String numbers) {
    }
}
