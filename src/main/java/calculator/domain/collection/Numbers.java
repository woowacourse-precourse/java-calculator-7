package calculator.domain.collection;

import calculator.domain.value.Number;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] tokens) {
        List<Number> numberList = Arrays.stream(tokens)
                .map(Number::new)
                .toList();
        return new Numbers(numberList);
    }

    public static Numbers empty() {
        return new Numbers(List.of(new Number("0")));
    }

    public int sum() {
        return numbers.stream().mapToInt(Number::getValue).sum();
    }
}
