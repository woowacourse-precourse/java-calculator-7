package calculator.model;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static Long sum(List<Long> inputNumbers) {
        return inputNumbers.stream().mapToLong(Long::longValue).sum();
    }
}
