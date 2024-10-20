package calculator;

import java.util.List;

public class Calculator {
    static public void run() {
        String input = CalculatorView.read();
        List<Integer> nums = CalculatorParser.parse(input);
        int ret = Calculator.sum(nums);
        CalculatorView.showResult(ret);
    }

    static public int sum(List<Integer> nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum > Integer.MAX_VALUE) {
                throw new ArithmeticException(String.format("%d를 초과한 값을 계산할 수 없습니다", Integer.MAX_VALUE));
            }
        }
        return (int) sum;
    }
}
