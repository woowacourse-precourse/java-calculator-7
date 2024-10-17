package calculator.calculator;

import calculator.delimiter.DelimiterFactory;
import calculator.utils.DelimiterUtils;
import java.util.List;
import java.util.Objects;

public class Calculator {

    private static final String POSITIVE_INTEGER_REGEX = "\\d+";

    private final DelimiterFactory delimiterFactory = new DelimiterFactory();

    public int calculate(String rawInput) {
        validateInput(rawInput);

        String cleanedInput = DelimiterUtils.removeSpaces(rawInput);
        Delimiter delimiter = delimiterFactory.getDelimiter(cleanedInput);
        List<String> numberStrings = delimiter.extractString(cleanedInput);
        List<String> spaceRemoved = numberStrings.stream().map(DelimiterUtils::removeSpaces).toList();

        validateString(spaceRemoved);

        List<Integer> inputNumbers = spaceRemoved.stream()
                .map(Integer::parseInt)
                .toList();

        return inputNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("null 값은 허용되지 않는다.");
        }
    }

    private void validateString(List<String> extractString) {
        if (extractString.stream().anyMatch(s -> !s.matches(POSITIVE_INTEGER_REGEX))) {
            throw new IllegalArgumentException("음수 혹은 숫자 외 값은 허용되지 않는다.");
        }
    }
}
