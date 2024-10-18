package calculator.domain;

import java.util.List;

public class AddNumber {
    private int sum = 0;
    public int getSum(final List<Integer> numbers){
        for (Integer num : numbers){
            sum += num;
        }
        return sum;
    }
}
