package calculator;

import java.util.List;

public class NumberCalculator {

    public static long calculateNumber(List<String> numbers) {
        long sum = 0;
        for (String number : numbers) {
            sum += Long.parseLong(number);
        }
        return sum;
    }
}
