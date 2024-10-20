package calculator.domain;

public final class Plus {

    public Number execute(final NumberList numberList) {
        final var result = numberList.list().stream()
            .mapToLong(Number::value)
            .sum();

        return Number.of(result);
    }
}