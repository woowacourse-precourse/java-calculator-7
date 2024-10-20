package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static final String ERROR_MESSAGE = "유효하지 않은 문자열입니다.";

    public static List<Integer> stringToNumbers(String input) {
        String expression = input;
        String customDelimiter = "";

        if (expression.startsWith("//")) {
            if (!expression.contains("\n")) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            int separatorIndex = expression.indexOf("\n");
            customDelimiter = "|" + expression.substring(2, expression.indexOf("\n"));
            expression = expression.substring(separatorIndex + 1);
        }

        String[] tokens = expression.split(",|:" + customDelimiter);

        return Arrays.stream(tokens).map(token -> {
            if (!isNumeric(token)) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            return Integer.parseInt(token);
        }).collect(Collectors.toList());
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
