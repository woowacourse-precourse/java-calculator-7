package calculator.model;

import java.util.List;

public class Calculate {
    private final List<Long> numbers;
    private long result = 0;

    public Calculate(List<Long> numbers) {
        this.numbers = numbers;
    }

    public Long sum() {
        for (Long number : numbers) {
            result = addWithOverFlowCheck(result, number);
        }

        return result;

    }

    private long addWithOverFlowCheck(long result, Long number) {
        try {
            return Math.addExact(result, number);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("계산기가 연산 할 수 있는 범위를 넘어섰습니다.");
        }
    }
}
