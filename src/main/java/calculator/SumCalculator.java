package calculator;

import java.util.List;

public class SumCalculator {

    public int calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
