package calculator.model;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    private List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] numberStrings) {
        return new Numbers(
                Arrays.stream(numberStrings)
                        .map(Number::from)
                        .toList()
        );
    }

    public Number sumNumbers() {
        return numbers.stream()
                .reduce(Number.from("0"), Number::add);
    }
}
