package calculator.domain.vo.number;

import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.domain.vo.delimiter.Delimiters;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(INVALID_COLLECTION.getMessage());
        }
    }

    public static Numbers from(final List<Number> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers extractFrom(final String input, Delimiters delimiters) {
        List<Number> numbers = distinguishNumberByDelimiters(input, delimiters);
        return new Numbers(numbers);
    }

    private static List<Number> distinguishNumberByDelimiters(String input, Delimiters delimiters) {
        input = normalizeInput(input);

        String[] values = input.split(delimiters.getDelimiterRegex());

        List<Number> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(Number.from(value));
        }

        return numbers;
    }

    private static String normalizeInput(String input) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("\n") + 1);
        }

        return input;
    }

    public BigInteger reduce() {
        return numbers.stream()
            .map(Number::getValue)
            .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
