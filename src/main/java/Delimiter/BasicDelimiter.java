package Delimiter;

public class BasicDelimiter {

    public static final String ERROR_INPUT_IS_NUMBER = "[ERROR] 구분자 외 입력은 오직 숫자만 가능합니다.";
    public static final String ERROR_INPUT_IS_POSITIVE = "[ERROR] 숫자는 양수만 입력 가능합니다.";
    public static final String ERROR_INPUT_IS_EMPTY = "[ERROR] 구분자 사이에 값을 입력해야 합니다.";


    public static int[] getNumber(String input) {
        String[] tokens = input.split(",|:");
        int[] numbers = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                checkIsEmpty(tokens[i]);
                numbers[i] = isPositive(Integer.parseInt(tokens[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NUMBER);
        }
        return numbers;
    }

    private static void checkIsEmpty(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_EMPTY);
        }
    }

    private static int isPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_POSITIVE);
        }
        return number;
    }
}
