package calculator;

import java.util.List;

public class Calculator {

    public int sumNumbers(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
