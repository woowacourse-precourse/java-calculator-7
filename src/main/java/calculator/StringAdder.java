package calculator;

import java.util.List;

public class StringAdder {
    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(n -> n).sum();
    }
}
