package calculator.util;

import java.util.Arrays;

public class Utils {

    public static int[] stringToIntegerArray(String[] stringArr){
        return Arrays.stream(stringArr)
                .mapToInt(Integer::parseInt).toArray();
    }

    public static int calculateArraySum(int[] numbers){
        return (numbers == null) ? 0 : Arrays.stream(numbers).sum();
    }

}
