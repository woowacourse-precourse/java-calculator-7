package calculator.model;

import java.util.List;

public class Calculator {

    public Integer addAll(List<Integer> numbers) {
        long sum = numbers.stream().mapToLong(Integer::longValue).sum();

        if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        return (int) sum;
    }
}
