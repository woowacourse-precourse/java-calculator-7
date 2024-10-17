package calculator;

import java.util.Arrays;

public abstract class Validator {

    public static boolean isCustom(String inputString){
        String regex = "^//.\\\\n.*$";
        return inputString.matches(regex);
    }

    public static int[] validateToIntArray(String[] stringArray){
        return Arrays.stream(stringArray)
                .mapToInt(string -> {
                    try {
                        return Integer.parseInt(string);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                }).toArray();
    }

    public static void checkHasNotPositive(int [] intArray){
        boolean hasNotPositive = Arrays.stream(intArray)
                .anyMatch(element -> element <= 0);
        if (hasNotPositive) {
            throw new IllegalArgumentException("양수가 아닌 수가 포함되어 있습니다.");
        }
    }
}
