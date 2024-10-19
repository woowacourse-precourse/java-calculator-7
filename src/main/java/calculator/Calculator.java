package calculator;

import java.util.List;

public class Calculator {

    public int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
            }
            sum += number;
        }
        return sum;
    }
}
