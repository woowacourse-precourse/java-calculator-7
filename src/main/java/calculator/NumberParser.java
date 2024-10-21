package calculator;

import static calculator.LiteralString.INVALID_INPUT_FORMAT;
import static calculator.LiteralString.NATURAL_NUMBER_ACCEPT_ONLY;

public class NumberParser {
    public static int parseAndSum(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += convertToNaturalNumber(token);
        }
        return sum;
    }

    private static int convertToNaturalNumber(String token) {
        try {
            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException(NATURAL_NUMBER_ACCEPT_ONLY + ":" + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT + ":" + token);
        }
    }
}
