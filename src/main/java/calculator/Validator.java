package calculator;

public class Validator {
    public static void isAllPositiveNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("양수만 입력하실 수 있습니다.");
            }
        }
    }
}
