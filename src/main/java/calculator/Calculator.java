package calculator;

import java.util.List;

public class Calculator {

    public Long sum(List<Long> inputNumbers) {
        return inputNumbers.stream().mapToLong(Long::longValue).sum();
    }
}
