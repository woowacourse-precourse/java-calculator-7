package calculator.model;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static Long sum(List<Long> inputNumbers) {
        if (inputNumbers.size() > 10) {
            throw new IllegalArgumentException("10개 이상의 숫자를 더할 수 없습니다.");
        }

        return inputNumbers.stream().mapToLong(Long::longValue).sum();
    }
}
