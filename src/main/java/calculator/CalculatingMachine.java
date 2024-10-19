package calculator;

import java.util.List;

public class CalculatingMachine {
    public Long calculate(List<Long> nums) {
        Long result = 0L;
        for (Long num : nums) {
            result += num;
        }
        return result;
    }
}
