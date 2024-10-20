package calculator.domain;

import java.util.List;

public class Calculator {

    public long sum(List<Long> numbers) {
        return numbers.stream()
                .reduce(0L, Long::sum);
    }

}
