package calculator.domain.adder;

import java.util.List;

public class IntegerAdder implements Addable<Integer> {

    private static final Integer MAX_VALUE = Integer.MAX_VALUE;
    private static final Integer MIN_VALUE = Integer.MIN_VALUE;

    @Override
    public Integer addNumbers(final List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = addSafely(sum, number);
        }

        return sum;
    }

    private int addSafely(final int number1, final int number2) {
        if (number2 > 0 && number1 > MAX_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        if (number2 < 0 && number1 < MIN_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        return number1 + number2;
    }

}
