package calculator;

public class Calculator {
    public int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            if (sum > Integer.MAX_VALUE - number) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }

        return sum;
    }
}