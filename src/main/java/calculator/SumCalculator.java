package calculator;

import java.util.List;

public class SumCalculator implements Calculator {

    @Override
    public int sum(List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            validateRange(sum, number);
            sum += number;
        }

        return sum;
    }

    private void validateRange(int sum, int number) {
        int MAX_SUM = Integer.MAX_VALUE;
        if(sum > MAX_SUM - number) {
            throw new IllegalArgumentException("합계가 최대값을 초과했습니다.");
        }
    }
}
