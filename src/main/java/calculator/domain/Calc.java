package calculator.domain;

import java.util.List;

public class Calc {

    private Long value = 0L;

    public void sumAllNumbers (List<Long> numbers) {
        value = numbers.stream().mapToLong(Long::longValue).sum();
    }

    public Long getValue() {
        return value;
    }
}
