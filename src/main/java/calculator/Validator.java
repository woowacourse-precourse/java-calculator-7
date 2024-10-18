package calculator;

public class Validator {
    public static void validate(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("negative input is not allowed");
            }
        }
    }
}

