package calculator;

import java.util.Arrays;

public class Result {

    public int add(String[] userNumber) {
        int[] numbers = new int[userNumber.length];
        for (int i = 0; i < userNumber.length; i++) {
            numbers[i] += Integer.parseInt(userNumber[i]);
            if (numbers[i] < 0) {
                throw new IllegalArgumentException();
            }
        }
        return Arrays.stream(numbers).sum();
    }

}
