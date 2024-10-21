package calculator;

import java.math.BigDecimal;
import java.util.List;

public class InputSequence {
    public static final BigDecimal SUM_INITIAL_VALUE = BigDecimal.valueOf(0);
    private final List<BigDecimal> sequence;

    public InputSequence(List<BigDecimal> sequence) {
        this.sequence = sequence;
    }

    public BigDecimal sum() {
        return sequence.stream().reduce(SUM_INITIAL_VALUE, BigDecimal::add);
    }
}
