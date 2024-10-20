package calculator;

public class Adder implements Calculator {
    @Override
    public int calculate(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result += num;
        }

        return result;
    }
}
