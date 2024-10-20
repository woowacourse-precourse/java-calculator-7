package calculator.domain;

import java.util.List;
import java.util.stream.Stream;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] split) throws NumberFormatException {
        List<Integer> integers = Stream.of(split)
                .map(Integer::parseInt)
                .toList();
        return new Numbers(integers);
    }

    public int sum() {
        if(numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
