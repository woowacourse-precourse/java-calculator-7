package calculator;

import java.util.List;

public class CalculatingMachine {
    private List<Long> nums;

    CalculatingMachine(List<Long> nums) {
        this.nums = nums;
    }

    /*
  계산하는 거 정도는 가능.
  모델에 어느정도까지 역할 분배를 시킬까?
   */
    public Long calculate() {
        Long result = 0L;
        for (Long num : this.nums) {
            result += num;
        }
        return result;
    }
}
