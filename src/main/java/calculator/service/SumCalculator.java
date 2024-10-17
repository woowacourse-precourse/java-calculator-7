package calculator.service;

public class SumCalculator {

    // 오로지 값을 더함
    public int sum(int[] nums){
        int result = 0;
        for(int num : nums) result += num;

        return result;
    }
}
