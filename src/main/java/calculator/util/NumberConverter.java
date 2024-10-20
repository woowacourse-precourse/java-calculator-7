package calculator.util;

import java.util.Arrays;

public class NumberConverter {
    public static int[] convertToInt(String... strNums) {
        return Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
    }

    private NumberConverter() {
    }
}
