package calculator;

import static calculator.util.CalculatorConst.END_DELIMITER;
import static calculator.util.CalculatorConst.START_DELIMITER;

import calculator.util.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class Division {
    private static StringBuilder delimiter = new StringBuilder(":|,");

    public static List<String> split(String input) {
        validateFormat(input);
        if (input.startsWith(START_DELIMITER)) {
            validateCustomDelimiter(input);
            delimiter.append("|").
                    append(input, input.indexOf(START_DELIMITER) + 2, input.indexOf(END_DELIMITER));
            input = input.substring(input.indexOf(END_DELIMITER) + 2);
        }
        return Arrays.stream(input.split(delimiter.toString())).toList();


    }

    private static void validateFormat(String input) {
        char[] charArray = input.toCharArray();
        boolean isValidStart = input.isBlank() || Character.isDigit(charArray[0]) || input.startsWith(START_DELIMITER);
        if (!isValidStart) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT);
        }
    }

    private static void validateCustomDelimiter(String input) {
        String substring = input.substring(input.indexOf(START_DELIMITER), input.indexOf(END_DELIMITER));
        if (substring.equals(START_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER);

        }
    }


}
