package calculator;

public class OperationExecutor {
    public int calculate(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
