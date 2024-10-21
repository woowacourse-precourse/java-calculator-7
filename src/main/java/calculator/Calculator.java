package calculator;

import java.util.ArrayList;

public class Calculator {
    public static int sum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
