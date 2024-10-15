package calculator;

import java.util.List;

public class SumCalculator implements Calculator {

    @Override
    public long sum(List<Integer> numbers) {
        long sum = 0;
        for(int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
