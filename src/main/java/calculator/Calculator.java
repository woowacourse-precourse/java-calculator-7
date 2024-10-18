package calculator;

import java.util.Vector;

public class Calculator {
    public int getSum(Vector<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
