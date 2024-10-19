package Delimiter;

import exception.ErrorMessage;

public class BasicDelimiter {

    public static int[] getNumber(String input) {
        String[] tokens = input.split(",|:");
        int[] numbers = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                checkIsEmpty(tokens[i]);
                numbers[i] = isPositive(Integer.parseInt(tokens[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NUMBER.toString());
        }
        return numbers;
    }

    private static void checkIsEmpty(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_EMPTY.toString());
        }
    }

    private static int isPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_POSITIVE.toString());
        }
        return number;
    }
}
