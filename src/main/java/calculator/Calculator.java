package calculator;

public class Calculator {

    public int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
