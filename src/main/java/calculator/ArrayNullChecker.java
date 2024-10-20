package calculator;

public class ArrayNullChecker {
    /*
        구분자로 나눈 숫자들이 없으면, 예외처리 하는 로직
     */
    public static void checkNumbersNull(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("숫자 X");
        }
    }
}
