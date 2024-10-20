package calculator;

public class Calculator {
    public int calcSum(int[] input) {
        int sum = 0;
        for (int num : input) {
            sum += num;
        }
        return sum;
    }
}
