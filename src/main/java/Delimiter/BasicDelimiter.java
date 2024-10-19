package Delimiter;

import exception.ErrorMessage;

public class BasicDelimiter extends Delimiter {

    public static int[] getNumber(String input) {
        String[] tokens = input.split(",|:");
        int[] numbers = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                Delimiter.checkIsEmpty(tokens[i]);
                numbers[i] = isPositive(Integer.parseInt(tokens[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NUMBER.toString());
        }
        return numbers;
    }
}
