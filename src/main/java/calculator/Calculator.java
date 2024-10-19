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
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
