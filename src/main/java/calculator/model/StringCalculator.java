package calculator.model;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class StringCalculator<E> implements Calculator<E> {

    private final E result;
    private final BiFunction<E,E,E> operation;
    private final Predicate<E> validCondition;

    public StringCalculator(E initialValue,
            BiFunction<E,E,E> operation,
            Predicate<E> validCondition) {
        this.result = initialValue;
        this.operation = operation;
        this.validCondition = validCondition;
    }

    @Override
    public E calculate(List<E> numbers) {
        return numbers.stream()
                .map(this::checkValueOrThrowException)
                .reduce(result, operation::apply);
    }

    private E checkValueOrThrowException(E value) {
        if (validCondition.negate().test(value)) {
            throw new IllegalArgumentException("연산 가능한 값이 아닙니다.");
        }
        return value;
    }
}
