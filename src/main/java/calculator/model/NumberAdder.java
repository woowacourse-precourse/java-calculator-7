package calculator.model;

import java.util.List;

public class NumberAdder {
    public static int addNumber(final List<Number> numbers) {
        int sum = 0;
        for (Number n : numbers) {
            sum += n.getNumber();
        }
        return sum;
    }
}
