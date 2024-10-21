package calculator.domain;

import java.util.Vector;

public class MathOperator {
    public static int getSum(Vector<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
