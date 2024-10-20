package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static final String ERROR_MESSAGE = "유효하지 않은 문자열입니다.";

    public static List<Integer> stringToNumbers(String str) {
        if (!Character.isDigit(str.charAt(str.length() - 1))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        Expression expression = getExpression(str);
        String delimiters = ",|:" + expression.customDelimiter();
        String[] tokens = expression.str.split(delimiters);

        return Arrays.stream(tokens).map(token -> {
                    if (!isNumeric(token)) {
                        throw new IllegalArgumentException(ERROR_MESSAGE);
                    }
                    return Integer.parseInt(token);
                }
        ).collect(Collectors.toList());
    }

    private static Expression getExpression(String str) {
        if (str.startsWith("//")) {
            if (!str.contains("\\n")) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }

            int separatorIndex = str.indexOf("\\n");
            String customDelimiter = "|" + str.substring(2, separatorIndex);

            if (customDelimiter.equals("|")) {
                customDelimiter = "";
            }

            if (customDelimiter.equals("|\\")) {
                customDelimiter = "|\\\\";
            }

            String expression = str.substring(separatorIndex + 2);
            return new Expression(expression, customDelimiter);
        }
        return new Expression(str, "");
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

    private record Expression(String str, String customDelimiter) {
    }
}
