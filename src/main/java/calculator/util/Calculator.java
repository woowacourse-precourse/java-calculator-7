package calculator.util;

public class Calculator {

    public static int calculate(int[] arr) throws Exception {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}
