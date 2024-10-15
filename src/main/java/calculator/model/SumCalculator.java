package calculator.model;

import java.util.List;

public class SumCalculator {

    public int sum(List<Integer> nums) {
        int result = 0;
        for (Integer num : nums) {
            result += num;
        }
        return result;
    }
}
