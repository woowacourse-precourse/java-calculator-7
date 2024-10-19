package calculator.calculate;

public class Calculator {
    public int calculateNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
