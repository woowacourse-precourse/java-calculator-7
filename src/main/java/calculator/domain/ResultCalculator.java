package calculator.domain;

import java.util.List;

public class ResultCalculator {

    // List 내부의 수를 모두 합한 후 반환
    public long getSum(List<Integer> numbers){
        long sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
