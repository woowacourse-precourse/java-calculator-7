package calculator;

import java.util.List;

public class Calculator {
    
    public static int sum(List<Integer> input) {
        int sum = 0;
        for (int number : input) {
            sum += number;
        }
        return sum;
    }
}
