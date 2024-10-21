package calculator;

public class InputValidator {
    public static void checkNegativeNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}