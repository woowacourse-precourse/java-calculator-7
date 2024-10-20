package calculator.model;

import java.util.List;

public class Calculator {

    /**
     * @param numbers 계산할 Long 타입 List
     * @return 계산된 합
     */
    public long calculateSum(List<Long> numbers) {
        long sum = 0;
        for (Long number : numbers) {
            sum += number;
        }
        return sum;
    }
}
