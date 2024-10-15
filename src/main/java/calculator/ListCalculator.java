package calculator;

import java.util.List;

public class ListCalculator {

    public long calculate(List<Long> input) {
        long sum = 0;
        for(Long i : input) sum += i;
        return sum;
    }
}
