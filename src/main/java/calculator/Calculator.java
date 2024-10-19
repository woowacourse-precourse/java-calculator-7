package calculator;

public class Calculator {
    public static int sum(int[] num) {
        int total = 0;
        for (int i : num) {
            total += i;
        }
        return total;
    }
}
