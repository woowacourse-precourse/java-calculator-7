package calculator.model;

import calculator.model.exception.ShouldNotBeNullException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CalculateSystem {
    private Numbers numbers;

    // Constructor
    private CalculateSystem(Numbers numbers) {
        validateNotNull(numbers);
        this.numbers = Objects.requireNonNull(numbers);
    }

    public static CalculateSystem of(List<Integer> source) {
        Numbers numbers = Numbers.of(source);
        return new CalculateSystem(numbers);
    }

    // Validation
    private void validateNotNull(Numbers numbers) {
        Optional.ofNullable(numbers)
                .orElseThrow(ShouldNotBeNullException::new);
    }

    // Domain Logic
    public Integer sum() {
        return numbers.sum();
    }
}
