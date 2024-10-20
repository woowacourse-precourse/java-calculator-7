package calculator.util;

public class NumberParser {

    public static int[] stringToIntArray(String[] input) throws Exception {
        int[] result = new int[input.length];
        try {
            for (int i = 0; i < input.length; i++) {
                result[i] = Integer.parseInt(input[i]);

                // 음수인 경우 예외 발생
                if (result[i] < 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
