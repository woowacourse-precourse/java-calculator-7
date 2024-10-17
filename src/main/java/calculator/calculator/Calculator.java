package calculator.calculator;

import calculator.delimiter.DelimiterFactory;
import calculator.utils.DelimiterUtils;
import calculator.utils.ErrorMessage;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class Calculator {

    private static final String POSITIVE_INTEGER_REGEX = "\\d+";

    private final DelimiterFactory delimiterFactory = new DelimiterFactory();

    public BigInteger calculate(String rawInput) {
        validateInput(rawInput);

        Delimiter delimiter = delimiterFactory.getDelimiter(rawInput);
        List<String> numberStrings = delimiter.extractString(rawInput);
        List<String> spaceRemoved = numberStrings.stream()
                .map(DelimiterUtils::removeSpaces)
                .toList();

        if (spaceRemoved.stream().allMatch(String::isBlank)) {
            return BigInteger.ZERO;
        }

        validateString(spaceRemoved);

        List<Long> inputNumbers = spaceRemoved.stream()
                .map(Long::parseLong)
                .toList();

        return inputNumbers.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private void validateInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_NOT_ALLOWED.getMessage());
        }
    }

    private void validateString(List<String> extractString) {
        if (extractString.stream().anyMatch(s -> !s.matches(POSITIVE_INTEGER_REGEX))) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBERS_ALLOWED.getMessage());
        }
    }
}
