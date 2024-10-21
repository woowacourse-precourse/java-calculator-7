package calculator.parser;

import calculator.exception.ErrorMessage;
import java.util.Arrays;

public class StringParser {
    private static StringParser instance;

    private StringParser() {
    }

    public static StringParser getInstance() {
        if (instance == null) {
            instance = new StringParser();
        }

        return instance;
    }

    public int[] parse(String input) {

        String[] separatedInputs = input.split("\\s+");

        return Arrays.stream(separatedInputs).mapToInt(this::parseInt).toArray();
    }

    private int parseInt(String number) {
        if (number.startsWith("-")) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getValue());
        }

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getValue());
        }
    }
}
