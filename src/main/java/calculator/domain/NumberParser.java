package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {
    private final Validator validator;

    public NumberParser(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> parseToIntegers(List<String> inputs) {
        List<Integer> numbers = inputs.stream()
                .peek(validator::validateIsInteger)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validator.validateAllPositive(numbers);
        return numbers;
    }
}
