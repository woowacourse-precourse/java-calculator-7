package calculator;

import java.util.List;

public class Calculator {

    public static long sum(List<Integer> numbers) {
        long sum = 0L;
        for (int number : numbers)
            sum += number;

        return sum;
    }
}
