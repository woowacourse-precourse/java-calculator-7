package calculator;

import java.util.List;

public class Adder {
    public int add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
