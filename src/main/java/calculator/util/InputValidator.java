package calculator.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateExpression(String expression, Set<Character> delimiters) {
        for (Character c : expression.toCharArray()) {
            if (!delimiters.contains(c) && !Character.isDigit(c) && c != '.') {
                throw new IllegalArgumentException("유효하지 않은 계산식입니다.");
            }
        }
    }

    public static void validateCustomDelimiters(char[] delimiters) {
        if (isDelimiterRepeated(delimiters)) {
            throw new IllegalArgumentException("커스텀 구분자를 중복하여 지정할 수 없습니다.");
        }
        if (hasDefaultDelimiter(delimiters)) {
            throw new IllegalArgumentException("기본 구분자는 커스텀 구분자로 지정할 수 없습니다.");
        }
        if (hasDelimiterNumber(delimiters)) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자를 지정할 수 없습니다.");
        }
    }

    private static boolean isDelimiterRepeated(char[] delimiters) {
        Set<Character> uniqueDelimiters = new HashSet<>();

        for (char delimiter : delimiters) {
            if (!uniqueDelimiters.add(delimiter)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDefaultDelimiter(char[] delimiters) {
        for (char delimiter : delimiters) {
            if (delimiter == ',' || delimiter == ':') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDelimiterNumber(char[] delimiters) {
        for (char delimiter : delimiters) {
            if (Character.isDigit(delimiter)) {
                return true;
            }
        }
        return false;
    }
}
