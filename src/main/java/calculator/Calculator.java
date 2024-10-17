package calculator;

/**
 * Calculator
 */
public class Calculator {

    public int addNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
