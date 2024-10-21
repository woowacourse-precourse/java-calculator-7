package calculator;

public class StringCalculator {
    public int calculate(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
