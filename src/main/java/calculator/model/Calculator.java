package calculator.model;

import java.util.List;

public class Calculator {

    private long calculateSum(List<Long> numbers) {
        long sum = 0;
        for(Long number : numbers) {
            sum += number;
        }
        return sum;
    }
}
