package calculator;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(List<String> value) {
        return new Numbers(toNumbers(value));
    }

    private static List<Number> toNumbers(List<String> input) {
        return input.stream().map(Number::from).toList();
    }

    public Number sum() {
        Number result = Number.zero();
        for (Number number : numbers) {
            result = result.sum(number);
        }
        return result;
    }
}
