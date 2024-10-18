package calculator.calculate;

import java.util.Arrays;

public class Calculator {
    public static int getResult(int[] numberArr) {
        if (numberArr.length == 0) {
            return 0;
        }

        return Arrays.stream(numberArr).sum();
    }

    public static void printResult(int result) {
        String message = "결과 : " + result;
        System.out.println(message);
        return;
    }
}
