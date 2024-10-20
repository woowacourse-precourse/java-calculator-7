package calculator;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public int Calculate(List<Integer> nums){
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}
