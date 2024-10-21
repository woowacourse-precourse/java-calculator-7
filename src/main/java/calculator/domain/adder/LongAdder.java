package calculator.domain.adder;

import java.util.List;

public class LongAdder implements Addable<Long> {

    private static final Long MAX_VALUE = Long.MAX_VALUE;
    private static final Long MIN_VALUE = Long.MIN_VALUE;

    @Override
    public Long addNumbers(final List<Long> numbers) {
        long sum = 0;
        for (Long number : numbers) {
            sum = addSafely(sum, number);
        }

        return sum;
    }

    private long addSafely(final long number1, final long number2) {
        if (number2 > 0 && number1 > MAX_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        if (number2 < 0 && number1 < MIN_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        return number1 + number2;
    }

}
