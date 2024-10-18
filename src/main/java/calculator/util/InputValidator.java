package calculator.util;

import java.util.Set;

public class InputValidator {

    public static void validateExpression(String expression, Set<Character> delimiters) {
        for (Character c : expression.toCharArray()) {
            if (!delimiters.contains(c) && !Character.isDigit(c) && c != '.') {
                throw new IllegalArgumentException("유효하지 않은 계산식입니다.");
            }
        }
    }
}
