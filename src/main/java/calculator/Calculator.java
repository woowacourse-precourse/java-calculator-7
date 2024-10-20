package calculator;

import java.util.List;

public class Calculator {

    public static long add(List<Long> numbers) {
        long result = 0;
        for (long number : numbers) {
            result += number;
        }
        return result;
    }
}
