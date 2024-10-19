package calculator;

import java.util.Arrays;
import java.util.List;

public class InputSequence {
    public static final long SUM_INITIAL_VALUE = 0L;
    private final List<Long> sequence;

    public InputSequence(List<Long> sequence) {
        this.sequence = sequence;
    }

    public Long sum() {
        return sequence.stream().reduce(SUM_INITIAL_VALUE, (a,b) -> {
            long sum = a + b;
            if (sum < 0) {
                throw new IllegalArgumentException("더한 값이 너무 큽니다.");
            }
            return sum;
        });
    }
}
