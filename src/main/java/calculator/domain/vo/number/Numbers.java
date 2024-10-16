package calculator.domain.vo.number;

import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.infrastructure.exception.ErrorCode;
import java.math.BigInteger;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Number> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException(INVALID_COLLECTION.getMessage());
        }
    }

    public static Numbers from(final List<Number> numbers) {
        return new Numbers(numbers);
    }

    public BigInteger reduce() {
        return numbers.stream()
            .map(Number::getValue)
            .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
