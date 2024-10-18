package calculator;

import java.util.List;

public class NumberCalculator {

    public static long calculateNumber(List<String> numbers) {
        long sum = INIT_SUM;
        for (String number : numbers) {
            sum += Long.parseLong(number);
        }
        return sum;
    }

    private static final int INIT_SUM = 0;
}
