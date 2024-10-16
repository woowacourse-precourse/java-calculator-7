package calculator;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

    }
    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
