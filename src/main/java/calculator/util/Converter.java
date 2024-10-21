package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static final String ERROR_MESSAGE = "유효하지 않은 문자열입니다.";

    public static List<Integer> stringToNumbers(String str) {
        validateString(str);
        Expression expression = getExpression(str);
        String[] numbers = expression.getNumbers();
        validateNumbers(numbers);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Expression getExpression(String str) {
        if (str.startsWith("//")) {
            String customDelimiter = str.substring(2, 3);
            if (customDelimiter.equals("\\")) {
                customDelimiter += "\\";
            }
            return new Expression(str.substring(5), ",|:|" + customDelimiter);
        }
        return new Expression(str, ",|:");
    }

    private static void validateString(String str) {
        if (!Character.isDigit(str.charAt(str.length() - 1))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (str.startsWith("//") && !str.contains("\\n")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void validateNumbers(String[] numbers) {
        Arrays.stream(numbers)
                .filter(number -> !isNumeric(number))
                .forEachOrdered(number -> {
                    throw new IllegalArgumentException(ERROR_MESSAGE);
                });
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) || str.equals("0")) {
                return false;
            }
        }
        return true;
    }

    private record Expression(String str, String delimiters) {
        private String[] getNumbers() {
            return str.split(delimiters);
        }
    }
}
