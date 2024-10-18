package calculator.adder;

import java.util.List;

public class IntegerAdder implements Addable {

    private static final Integer MAX_VALUE = Integer.MAX_VALUE;

    @Override
    public Integer addNumbers(final List<Number> numbers) {
        int sum = 0;
        for (Number number : numbers) {
            sum = addSafely(sum, number.intValue());
        }

        return sum;
    }

    private int addSafely(final int number1, final int number2) {
        if (number1 > 0 && number2 > MAX_VALUE - number1) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        if (number2 > 0 && number1 > MAX_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        return number1 + number2;
    }

}
