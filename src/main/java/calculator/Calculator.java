package calculator;

public class Calculator {
    public int calcSum(int[] input) {
        return sumNums(input);
    }

    private int sumNums(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
