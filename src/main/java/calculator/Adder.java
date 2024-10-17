package calculator;

import java.util.List;

public class Adder {

    /**
     * 숫자들의 합 계산
     */
    public int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
