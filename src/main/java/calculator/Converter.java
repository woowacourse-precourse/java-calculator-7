package calculator;

public class Converter {
    public static int[] toIntArray(String[] stringArray) {
        return java.util.Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
