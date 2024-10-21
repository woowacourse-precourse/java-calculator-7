package calculator;

import java.util.List;

public class Calculator {
    public static int sum(List<Integer> result) {
        int sum = 0;
        for (Integer i : result) {
            sum += i;
        }
        return sum;
    }
}
