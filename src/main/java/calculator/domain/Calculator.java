package calculator.domain;

import java.util.List;

public class Calculator {

    public Integer sumOf(List<Integer> numbers) {
        return numbers.stream()
            .reduce(Integer::sum)
            .orElseThrow(IllegalArgumentException::new);
    }

}
