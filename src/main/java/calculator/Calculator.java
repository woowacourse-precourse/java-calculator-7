package calculator;

import java.util.ArrayList;

public class Calculator {
    public static long sum(ArrayList<Integer> numbers) {
        try {
            long sum = 0;
            for (Integer number : numbers) {
                if(number <= 0) {
                    throw new IllegalArgumentException();
                } else {
                    sum += number;
                }
            }
            return sum;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
