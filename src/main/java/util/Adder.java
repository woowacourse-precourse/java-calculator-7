package util;

public class Adder {
    public static int getSum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }
}
