package calculator.utils;

import java.util.Arrays;

public abstract class CalculatorUtils {

    public static int sumSplitArray(String[] stringArray){
        return Arrays.stream(stringArray)
                .mapToInt(string -> {
                    try {
                        return Integer.parseInt(string);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                }).sum();
    }
}
