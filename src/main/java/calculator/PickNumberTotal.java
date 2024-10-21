package calculator;

public class PickNumberTotal {
    public static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number; //총합
        }
        return sum;
    }
}
