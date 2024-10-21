package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] split) throws NumberFormatException {
        if (split.length == 1 && split[0].isBlank()) {
            return new Numbers(new ArrayList<>());
        }
        List<Integer> integers = Stream.of(split)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();

        integers.stream()
                .filter(integer -> integer < 0)
                .forEach(integer -> {
                    throw new IllegalArgumentException("invalid number: number range must in positive integer");
                });
        return new Numbers(integers);
    }

    public int sum() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
