package calculator.processor.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String[] numbers) {
        if (numbers.length == 1 && numbers[0].isEmpty()) {
            this.numbers = List.of(Number.ZERO);
        } else {
            this.numbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .map(Number::new)
                .toList();
        }
    }

    public Number sum() {
        return numbers.stream().reduce(Number.ZERO, Number::plus);
    }
}
