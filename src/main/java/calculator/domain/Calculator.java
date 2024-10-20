package calculator.domain;

import java.util.List;

public class Calculator {

    /**
     * 덧셈 계산
     */
    public static int add(List<Integer> numbers) {
        int total = 0;
        for (Integer number : numbers) {
            total += number;
        }
        return total;
    }
}
