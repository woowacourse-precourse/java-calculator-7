package calculator.domain;

import java.util.List;

public record Numbers(
        List<Number> elements
) {

    public static Numbers from(final List<Number> elements) {
        return new Numbers(elements);
    }

    public int sum() {
        return elements.stream()
                       .mapToInt(Number::value)
                       .sum();
    }

    public void validateNegativeValue() {
        if (containsNegative()) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }
    }

    public boolean containsNegative() {
        return elements.stream()
                       .anyMatch(number -> number.value() < 0);
    }
}
