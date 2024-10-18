package calculator;

import java.util.List;

class NumberAdder {
    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}