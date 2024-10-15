package calculator;

import java.util.List;

public class SumCalculator implements Calculator {

    @Override
    public long sum(List<Integer> numbers) {
        long sum = 0;
        for(int number : numbers) {
            validateRange(sum, number);
            sum += number;
        }

        return sum;
    }

    private void validateRange(long sum, int number) {
        long MAX_SUM = Long.MAX_VALUE;
        if(sum > MAX_SUM - number) {
            throw new IllegalArgumentException("합계가 최대값을 초과했습니다.");
        }
    }
}
