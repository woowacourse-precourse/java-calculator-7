package calculator.util;

public class NegativeNumberHandler {
    // 음수 값이 있는지 체크하고 예외를 발생시킴
    public static void checkNegativeNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
        }
    }
}
