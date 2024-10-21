package calculator;

import java.util.ArrayList;

public class Calculator {
    public static long sum(ArrayList<Integer> numbers) {
        long sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
