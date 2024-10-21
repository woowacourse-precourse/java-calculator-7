package calculator.model;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class StringCalculator<T extends Number> implements Calculator<T> {

    private final T result;
    private final BiFunction<T, T, T> operation;
    private final Predicate<T> validCondition;

    public StringCalculator(T initialValue,
                            BiFunction<T, T, T> operation,
                            Predicate<T> validCondition) {
        this.result = initialValue;
        this.operation = operation;
        this.validCondition = validCondition;
    }

    @Override
    public T calculate(List<T> numbers) {
        return numbers.stream()
                .map(this::checkValueOrThrowException)
                .reduce(result, operation::apply);
    }

    private T checkValueOrThrowException(T value) {
        if (validCondition.negate().test(value)) {
            throw new IllegalArgumentException(value.toString() + ": 연산에 사용할 수 있는 값이 아닙니다.");
        }
        return value;
    }
}
