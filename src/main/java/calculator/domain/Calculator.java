package calculator.domain;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public int calculate(List<Integer> nums){
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}
