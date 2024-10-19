package calculator;

public class Calculator {
    private int sum;

    public int addNumbers(int[] numbers) {
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
