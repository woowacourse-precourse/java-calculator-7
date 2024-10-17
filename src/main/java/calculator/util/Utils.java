package calculator.util;

import java.util.Arrays;

public class Utils {

    public static int[] stringToIntegerArray(String[] stringArr){
        return Arrays.stream(stringArr)
                .mapToInt(Integer::parseInt).toArray();
    }

    public static int calculateArraySum(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
