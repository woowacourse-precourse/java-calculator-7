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
        if (hasCustomDelimiter(input)) {
            char customDelimiter = extractCustomDelimiter(input);
            input = trimCustomDelimiter(input);
            input = input.replace(customDelimiter, ' ');
        }

        input = input.replace(Delimiter.COMMA.getValue(), " ");
        input = input.replace(Delimiter.COLON.getValue(), " ");

        String[] separatedInputs = input.split("\\s+");

        return Arrays.stream(separatedInputs).mapToInt(this::parseInt).toArray();
    }

    private boolean hasCustomDelimiter(String input) {
        if (input.contains(Delimiter.CUSTOM_START.getValue()) && input.contains(Delimiter.CUSTOM_END.getValue())) {
            return true;
        }

        return false;
    }

    private char extractCustomDelimiter(String input) {
        int startIndex = input.indexOf(Delimiter.CUSTOM_START.getValue());
        int endIndex = input.indexOf(Delimiter.CUSTOM_END.getValue());

        validateCustomDelimiter(startIndex, endIndex);

        return input.charAt(startIndex + 2);
    }

    private String trimCustomDelimiter(String input) {
        return input.substring(5);
    }

    private void validateCustomDelimiter(int startIndex, int endIndex) {
        if (startIndex != 0 || endIndex != 3) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER.getValue());
        }
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
