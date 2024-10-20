package calculator.domain;

import static calculator.error.ErrorType.*;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(final String[] input) {
        this.numbers = convertToIntegers(input);
        validate();
    }

    private void validate() {
        numbers.forEach(number -> {
            if (number < 0) {
                throw new IllegalArgumentException(INPUT_NEGATIVE_NUMBER_ERROR.getMessage());
            }
        });

    }

    private List<Integer> convertToIntegers(final String[] strings) {
        try {
            return Arrays.stream(strings)
                    .map(s -> (s == null || s.trim().isEmpty()) ? 0 : Integer.parseInt(s.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
